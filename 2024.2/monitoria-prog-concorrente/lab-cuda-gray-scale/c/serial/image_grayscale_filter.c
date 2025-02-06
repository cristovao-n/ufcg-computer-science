#define STB_IMAGE_IMPLEMENTATION
#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "../lib/stb_image.h"
#include "../lib/stb_image_write.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <limits.h>
#include <time.h>

void convertToGrayscale(int width, int height, unsigned char *originalImage,
                        unsigned char *grayscaleImage) {
  // Convert each pixel to grayscale
  for (int y = 0; y < height; y++) {
    for (int x = 0; x < width; x++) {
      int idx = (y * width + x) * 3;
      unsigned char r = originalImage[idx];
      unsigned char g = originalImage[idx + 1];
      unsigned char b = originalImage[idx + 2];

      // Apply grayscale formula
      grayscaleImage[y * width + x] =
          (unsigned char)(0.299 * r + 0.587 * g + 0.114 * b);
    }
  }
}

/**
 * Applies a grayscale filter to an image.
 *
 * @param inputPath Path to the input image
 * @param outputPath Path to the output image
 * @param kernelSize Size of the mean kernel
 */
void applyGrayscaleFilter(const char *inputPath, const char *outputPath) {
  // Load the input image
  int width, height, channels;
  unsigned char *originalImage =
      stbi_load(inputPath, &width, &height, &channels, 3);
  if (!originalImage) {
    fprintf(stderr, "Error: Unable to load image %s\n", inputPath);
    exit(1);
  }

  // Allocate memory for the grayscale image
  unsigned char *grayscaleImage = malloc(width * height);
  if (!grayscaleImage) {
    fprintf(stderr,
            "Error: Unable to allocate memory for the grayscale image\n");
    stbi_image_free(originalImage);
    exit(1);
  }

  clock_t start = clock();
  convertToGrayscale(width, height, originalImage, grayscaleImage);
  clock_t end = clock();
  double time_spent = ((double)(end - start)) / CLOCKS_PER_SEC;
  printf("CPU execution time: %f ms\n", time_spent * 1000);

  // Save the grayscale image
  if (!stbi_write_jpg(outputPath, width, height, 1, grayscaleImage, 100)) {
    fprintf(stderr, "Error: Unable to save image %s\n", outputPath);
    free(grayscaleImage);
    stbi_image_free(originalImage);
    exit(1);
  }

  // Clean up
  free(grayscaleImage);
  stbi_image_free(originalImage);
}

/**
 * Main function for demonstration.
 *
 * Usage: ./script <input_file>
 */
int main(int argc, char *argv[]) {
  char cwd[PATH_MAX];

  if (getcwd(cwd, sizeof(cwd)) != NULL) {
    printf("Current working directory: %s\n", cwd);
  } else {
    perror("getcwd() error");
  }
  if (argc < 2) {
    fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
    return 1;
  }

  const char *inputFile = argv[1];
  const char *outputFile = "grayscale_output.jpg";

  applyGrayscaleFilter(inputFile, outputFile);

  printf("Grayscale image saved to %s\n", outputFile);

  return 0;
}