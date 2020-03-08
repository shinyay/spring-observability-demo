#!/usr/bin/env fish

docker run --rm -d \
--name=prometheus \
-p 9090:9090 \
-v (pwd)/prometheus.yml:/etc/prometheus/prometheus.yml \
prom/prometheus:v2.13.1 \
--config.file=/etc/prometheus/prometheus.yml

docker ps -a
