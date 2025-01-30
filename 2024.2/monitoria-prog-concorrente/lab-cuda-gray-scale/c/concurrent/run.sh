if [ -z "$1" ]; then
  input_file="3MB_parrot.png"
else
  input_file="$1"
fi

mkdir -p bin && nvcc -g -G image_grayscale_filter.cu -o bin/image_grayscale_filter.o
time bin/image_grayscale_filter.o ../../data/$input_file
