if [ -z "$1" ]; then
  input_file="3MB_parrot.png"
else
  input_file="$1"
fi

mkdir -p bin && gcc -g image_grayscale_filter.c -o bin/image_grayscale_filter.o -lm
time bin/image_grayscale_filter.o ../../data/$input_file
