#define STB_IMAGE_IMPLEMENTATION
#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "../lib/stb_image.h"
#include "../lib/stb_image_write.h"
#include <cuda_runtime.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define BLOCK_SIZE_1D 1024

__global__ void convertToGrayscale(unsigned char *originalImage, unsigned char *grayscaleImage, int width, int height)
{

  int x = blockIdx.x * blockDim.x + threadIdx.x;
  int y = blockIdx.y * blockDim.y + threadIdx.y;

  // Convert current pixel to grayscale
  if (x < width && y < height)
  {
    int idx = (y * width + x) * 3;
    unsigned char r = originalImage[idx];
    unsigned char g = originalImage[idx + 1];
    unsigned char b = originalImage[idx + 2];

    // Apply grayscale formula
    grayscaleImage[y * width + x] =
        (unsigned char)(0.299 * r + 0.587 * g + 0.114 * b);
  }
}

/**
 * Applies a grayscale filter to an image.
 *
 * @param inputPath Path to the input image
 * @param outputPath Path to the output image
 * @param kernelSize Size of the mean kernel
 */
void applyGrayscaleFilter(const char *inputPath, const char *outputPath)
{
  // Load the input image
  int width, height, channels;
  unsigned char *hostOriginalImage =
      stbi_load(inputPath, &width, &height, &channels, 3);
  if (!hostOriginalImage)
  {
    fprintf(stderr, "Error: Unable to load image %s\n", inputPath);
    exit(1);
  }

  // Allocate memory for the original image in the device
  unsigned char *deviceOriginalImage;
  cudaMalloc(&deviceOriginalImage, width * height * 3 * sizeof(unsigned char)); // 3 bytes per pixel

  // Copy the original image into the device
  cudaMemcpy(deviceOriginalImage, hostOriginalImage,
             width * height * 3 * sizeof(unsigned char), cudaMemcpyHostToDevice);

  // Allocate device memory to store the grayscale image
  unsigned char *deviceGrayscaleImage;
  cudaMalloc(&deviceGrayscaleImage, width * height * sizeof(unsigned char));

  dim3 blockSize(16, 16); // 16x16 threads per block
  dim3 gridSize((width + blockSize.x - 1) / blockSize.x, (height + blockSize.y - 1) / blockSize.y);

  cudaEvent_t start, stop;
  cudaEventCreate(&start);
  cudaEventCreate(&stop);

  cudaEventRecord(start);
  convertToGrayscale<<<gridSize, blockSize>>>(deviceOriginalImage, deviceGrayscaleImage, width, height);
  cudaDeviceSynchronize();
  cudaEventRecord(stop);

  cudaEventSynchronize(stop);
  float milliseconds = 0;
  cudaEventElapsedTime(&milliseconds, start, stop);
  printf("Kernel execution time: %f ms\n", milliseconds);

  // Allocate memory for the grayscale image in the host
  unsigned char *hostGrayscaleImage = (unsigned char *)malloc(width * height * sizeof(unsigned char));

  cudaMemcpy(hostGrayscaleImage, deviceGrayscaleImage,
             width * height * sizeof(unsigned char), cudaMemcpyDeviceToHost);

  // Save the grayscale image
  if (!stbi_write_jpg(outputPath, width, height, 1, hostGrayscaleImage, 100))
  {
    fprintf(stderr, "Error: Unable to save image %s\n", outputPath);
    free(hostGrayscaleImage);
    stbi_image_free(hostOriginalImage);
    exit(1);
  }

  // Clean up
  free(hostGrayscaleImage);
  stbi_image_free(hostOriginalImage);
  cudaFree(deviceOriginalImage);
  cudaFree(deviceGrayscaleImage);
}

/**
 * Main function for demonstration.
 *
 * Usage: ./script <input_file>
 */
int main(int argc, char *argv[])
{

    char cwd[PATH_MAX];
    if (getcwd(cwd, sizeof(cwd)) != NULL) {
        printf("Current working directory: %s\n", cwd);
    } else {
        perror("getcwd() error");
    }

  if (argc < 2)
  {
    fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
    return 1;
  }

  const char *inputFile = argv[1];
  const char *outputFile = "grayscale_output.jpg";

  applyGrayscaleFilter(inputFile, outputFile);

  printf("Grayscale image saved to %s\n", outputFile);

  return 0;
}