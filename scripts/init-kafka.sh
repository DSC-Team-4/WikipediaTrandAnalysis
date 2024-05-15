#!/bin/bash

/opt/bitnami/scripts/kafka/entrypoint.sh /opt/bitnami/scripts/kafka/run.sh &

while ! nc -z localhost 9092; do   
  echo "Waiting for Kafka to be ready..."
  sleep 1
done

sleep 3

echo "try topic create"

/opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1 --config retention.ms=60000 --topic wiki 2>&1 | tee /tmp/kafka-topic-create.log

wait