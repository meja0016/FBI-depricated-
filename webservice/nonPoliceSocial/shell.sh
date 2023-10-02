#!/bin/sh

for i in `cat list`; do
  for j in `cat 2023/list`; do
	 echo $j
    for k in `cat 2023/1/list`; do
	mkdir -p $i/$j/$k
        cp index.html $i/$j/$k	
    done
  done 
done

#for year in `cat list`; do
#	for month in `cat list`; do
#		for day in `cat list`; do
#    echo $day
#done;
#done; 

