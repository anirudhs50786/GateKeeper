package com.motocart.gatekeeper_microservice.utility;

import java.util.UUID;

public class CorrelationIdGenerator {

    public static String generateCorrelationId(String eventGenerator) {
        return UUID.randomUUID() + "x" + eventGenerator;
    }
}
