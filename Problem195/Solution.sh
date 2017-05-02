#! /bin/bash
#awk 'NR == 10' file.txt

count=0
while read line && [ $count -le 10 ]
do
	let 'count = count + 1'
	if [ $count -eq 10 ]
	then
		echo $line
		exit
		fi
		done < file.txt