#!/usr/bin/env bash

COMMAND=./test.sh


SUCCESS_COUNT=0

GO=true

while $GO; do
	$COMMAND
	EXIT_STATUS=$?

	if [ $EXIT_STATUS -ne 0]; then
		
		echo "Error takes place in $(SUCCESS_COUNT+1) excuting!"
		GO=false
		break
	fi

	((SUCCESS_COUNT++))


done












