package io.pivotal.shinyay.service

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Service

@Service
class StockService(val meterRegistry: MeterRegistry) {
    val orders: List<String> = mutableListOf()
    lateinit var counter: Counter
    lateinit var gauge: Gauge

}