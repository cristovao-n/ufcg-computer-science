#define STB_IMAGE_IMPLEMENTATION
#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "../lib/stb_image.h"
#include "../lib/stb_image_write.h"
#include <stdio.h>
#include <stdlib.h>

/**
 * Applies a mean filter to an image.
 *
 * @param inputPath Path to the input image
 * @param outputPath Path to the output image
 * @param kernelSize Size of the mean kernel
 */
void applyMeanFilter(const char *inputPath, const char *outputPath, int kernelSize) {
    // Load the input image
    int width, height, channels;
    unsigned char *originalImage = stbi_load(inputPath, &width, &height, &channels, 3);
    if (!originalImage) {
        fprintf(stderr, "Error: Unable to load image %s\n", inputPath);
        exit(1);
    }

    // Allocate memory for the output image
    unsigned char *filteredImage = malloc(width * height * 3);
    if (!filteredImage) {
        fprintf(stderr, "Error: Unable to allocate memory for the output image\n");
        stbi_image_free(originalImage);
        exit(1);
    }

    int pad = kernelSize / 2;

    // Apply the mean filter
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            long redSum = 0, greenSum = 0, blueSum = 0;
            int pixelCount = 0;

            // Process neighborhood
            for (int dy = -pad; dy <= pad; dy++) {
                for (int dx = -pad; dx <= pad; dx++) {
                    int nx = x + dx;
                    int ny = y + dy;

                    // Check bounds
                    if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                        int idx = (ny * width + nx) * 3;
                        redSum += originalImage[idx];
                        greenSum += originalImage[idx + 1];
                        blueSum += originalImage[idx + 2];
                        pixelCount++;
                    }
                }
            }

            // Compute averages and set the pixel value in the output image
            int idx = (y * width + x) * 3;
            filteredImage[idx] = (unsigned char)(redSum / pixelCount);
            filteredImage[idx + 1] = (unsigned char)(greenSum / pixelCount);
            filteredImage[idx + 2] = (unsigned char)(blueSum / pixelCount);
        }
    }

    // Save the filtered image
    if (!stbi_write_jpg(outputPath, width, height, 3, filteredImage, 100)) {
        fprintf(stderr, "Error: Unable to save image %s\n", outputPath);
        free(filteredImage);
        stbi_image_free(originalImage);
        exit(1);
    }

    // Clean up
    free(filteredImage);
    stbi_image_free(originalImage);
}

/**
 * Main function for demonstration.
 *
 * Usage: ./image_mean_filter <input_file>
 */
int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return 1;
    }

    const char *inputFile = argv[1];
    const char *outputFile = "filtered_output_concurrent.jpg";

    applyMeanFilter(inputFile, outputFile, 7);

    printf("Filtered image saved to %s\n", outputFile);

    return 0;
}
