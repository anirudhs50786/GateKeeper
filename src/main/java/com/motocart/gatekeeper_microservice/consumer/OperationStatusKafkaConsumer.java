package com.motocart.gatekeeper_microservice.consumer;

import com.motocart.gatekeeper_microservice.events.OperationStatusEvent;
import com.motocart.gatekeeper_microservice.service.RequestTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OperationStatusKafkaConsumer {
    private final RequestTrackerService trackerService;

    public OperationStatusKafkaConsumer(RequestTrackerService trackerService) {
        this.trackerService = trackerService;
    }

    @KafkaListener(topics = "operation-status-events", groupId = "proxy-service-group")
    public void consumeStatusEvent(OperationStatusEvent statusEvent){
        log.info("Operation response event received");
        trackerService.completeRequestProcessing(statusEvent.getCorrelationId(), statusEvent.getStatus());

    }
}
