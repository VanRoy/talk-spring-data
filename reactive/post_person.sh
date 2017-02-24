#!/bin/bash

END=100

for i in $(seq 1 $END); do

read
echo -en "\033[1A\033[2K"

# Read data from JSON
DATA=`jq ".[$i]" src/main/resources/persons.json`

# Remplate Random number by age
NUMBER=`jq ".[$i].age" src/main/resources/persons.json`
DATA=`echo $DATA | sed "s/\: $NUMBER/\: $((NUMBER/10))/"`

echo "Send data ( $i ) : $DATA"

# Send to application
curl -H 'Content-Type: application/json' localhost:8080/persons --data "$DATA"

done