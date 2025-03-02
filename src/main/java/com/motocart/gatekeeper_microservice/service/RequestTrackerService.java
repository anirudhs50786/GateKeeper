package com.motocart.gatekeeper_microservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class RequestTrackerService {

    private final Map<String, CompletableFuture<String>> pendingRequests = new ConcurrentHashMap<>();

    public CompletableFuture<String> registerRequest(String correlationId) {
        CompletableFuture<String> future = new CompletableFuture<>();
        pendingRequests.put(correlationId, future);
        return future;
    }

    public void completeRequestProcessing(String correlationId, String status) {
        CompletableFuture<String> future = pendingRequests.remove(correlationId);

        if (future != null) {
            log.info("Completing request for correlationId {} with status {}", correlationId, status);
            future.complete(status);
        } else {
            log.warn("No pending request found for correlationId {}", correlationId);
        }
    }
}

