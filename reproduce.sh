#!/usr/bin/env bash

CONTAINER_ID="$(docker run --rm -d -p 6379:6379 redislabs/redisearch:2.8.8)"

sleep 2

./mvnw spring-boot:run

docker kill "$CONTAINER_ID"
