# Spring Observability Demo

Overview

## Description

## Demo

### 1. Spring Actuator

Enable spring actuator endpoint on `application.yml`

```yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

#### 1.1. Actuator Endpoint

```
$ curl -XGET http://localhost:8080/actuator | jq

{
  "_links": {
    "self": {
      "href": "http://localhost:8080/actuator",
      "templated": false
    },
    "beans": {
      "href": "http://localhost:8080/actuator/beans",
      "templated": false
    },
    "caches-cache": {
      "href": "http://localhost:8080/actuator/caches/{cache}",
      "templated": true
    },
  :
  :
    "metrics": {
      "href": "http://localhost:8080/actuator/metrics",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
      "templated": true
    },
    "scheduledtasks": {
      "href": "http://localhost:8080/actuator/scheduledtasks",
      "templated": false
    },
    "mappings": {
      "href": "http://localhost:8080/actuator/mappings",
      "templated": false
    }
  }
}
```

#### 1.2. Prometheus Endpoint for Actuator

```
$ curl -XGET http://localhost:8080/actuator|jq .[].prometheus

{
  "href": "http://localhost:8080/actuator/prometheus",
  "templated": false
}
```

### 2. Prometheus

#### 2.1. Prometheus configuration on `prometheus.yml`

```yaml
scrape_configs:
  - job_name: 'spring_micrometer'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['127.0.0.1:8080']
```

- `targets`
  - `$ ifconfig en0 | awk '/inet / {print $2}'`
  - `$ ipconfig getifaddr en0`

#### 2.2. Prometheus Container

```
$ docker run --rm -d \
--name=prometheus \
-p 9090:9090 \
-v (pwd)/prometheus.yml:/etc/prometheus/prometheus.yml \
prom/prometheus:v2.13.1 \
--config.file=(pwd)/prometheus.yml
```

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
