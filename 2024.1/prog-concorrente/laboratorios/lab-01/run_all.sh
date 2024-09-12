#!/bin/bash

args=`find dataset -type f | xargs`

echo -e "\n\nRODANDO O PAITON IRRIIIIIIIIIIII"
time bash python/concurrent/run.sh $args

echo -e "\n\nRODANDO O JAVA IHUUUUUUUUUUUUUUU"
time bash java/concurrent/run.sh $args
