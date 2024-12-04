mkdir -p bin && gcc -g image_grayscale_filter.c -o bin/image_grayscale_filter.o -lm
time bin/image_grayscale_filter.o ../data/salt_and_pepper2.png
