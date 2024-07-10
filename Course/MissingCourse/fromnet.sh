#!/usr/bin/env bash


num=0
flag=0

echo "" > output
echo "" > error

while [[ flag -eq 0 ]]; do
	((num++))
	./test.sh 1>> output 2>> error
	if [[ $? -ne "0" ]]; then
		flag=1
	fi
done

echo "Error takes place in ($num)th excution"
