package com.motocart.gatekeeper_microservice.events;

import lombok.Data;

@Data
public class OperationStatusEvent {
    private String status;
    private String eventType;
    private String errorDetails;
    private String correlationId;
}
