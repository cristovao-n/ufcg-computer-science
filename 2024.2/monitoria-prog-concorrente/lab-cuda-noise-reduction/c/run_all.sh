if [ -n "$1" ]; then
  num_threads="$1"
else
  num_threads="2"
fi


# Serial
mkdir -p serial/bin && gcc -g serial/image_mean_filter.c -o serial/bin/image_mean_filter.o -lm
echo "Serial: start"
time serial/bin/image_mean_filter.o ../data/salt_and_pepper2.png
echo "Serial: end"

echo

# Concurrent
mkdir -p concurrent/bin && gcc -g concurrent/image_mean_filter.c -o concurrent/bin/image_mean_filter.o -lm
echo "Concurrent: start"
time concurrent/bin/image_mean_filter.o ../data/salt_and_pepper2.png
echo "Concurrent: end"
