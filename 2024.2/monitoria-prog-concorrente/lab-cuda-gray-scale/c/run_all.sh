if [ -z "$1" ]; then
  input_file="3MB_parrot.png"
else
  input_file="$1"
fi

# Serial
cd serial
echo "Serial: start"
bash run.sh $input_file
echo "Serial: end"

echo
cd ..

# Concurrent
cd concurrent
echo "Concurrent: start"
bash run.sh $input_file
echo "Concurrent: end"
