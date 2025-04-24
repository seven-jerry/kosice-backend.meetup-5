package org.some.example.healthidicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MqHealth implements HealthIndicator {

    @Override
    public Health health() {
        Map<String, String> map = new HashMap<>();
        map.put("OK", "10");
        map.put("ERROR", "0");
        Health.Builder status = Health.up()
                .withDetails(map);
        return status.build();
    }
}