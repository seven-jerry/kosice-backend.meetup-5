package org.some.example.observability;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component

@Slf4j
public class AlertSender {


    Map<ErrorCodes, Counter> counters = new HashMap<>();


    public AlertSender(MeterRegistry meterRegistry) {
        for (ErrorCodes value : ErrorCodes.values()) {
            var c = Counter.builder("someErrorCounter")
                    .tag("code", value.name())
                    .register(meterRegistry);
            counters.put(value, c);
        }

    }


    public void raiseAlert(ErrorCodes errorCodes) {
        counters.get(errorCodes).increment();
         log.warn("[code:{}][ids:{}] error caught.", errorCodes, ObservabilityContext.getContext());
        System.err.println("sending to alert system: [" + errorCodes + "] error raised");
    }
}
