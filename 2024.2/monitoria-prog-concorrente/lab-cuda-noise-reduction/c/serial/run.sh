mkdir -p bin && gcc -g image_mean_filter.c -o bin/image_mean_filter.o -lm
time bin/image_mean_filter.o ../data/salt_and_pepper2.png
