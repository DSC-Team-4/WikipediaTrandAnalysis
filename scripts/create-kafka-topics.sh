#!/bin/bash

while ! nc -z localhost 9092; do   
  sleep 1
done

/opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1 --config retention.ms=60000 --topic wiki