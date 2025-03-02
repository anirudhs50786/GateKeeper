package com.motocart.gatekeeper_microservice.api.rest.impl;

import com.motocart.gatekeeper_microservice.api.rest.ProductsResource;
import com.motocart.gatekeeper_microservice.dto.ProductsDTO;
import com.motocart.gatekeeper_microservice.producer.ProductsKafkaProducer;
import com.motocart.gatekeeper_microservice.service.RequestTrackerService;
import com.motocart.gatekeeper_microservice.utility.CorrelationIdGenerator;
import com.motocart.gatekeeper_microservice.utility.ObjectsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductsResourceImpl implements ProductsResource {

    private final ProductsKafkaProducer productsKafkaProducer;
    private final RequestTrackerService requestTrackerService;
    @Value("${api.timeout}")
    private int timeout;

    public ProductsResourceImpl(ProductsKafkaProducer productsKafkaProducer, RequestTrackerService requestTrackerService) {
        this.productsKafkaProducer = productsKafkaProducer;
        this.requestTrackerService = requestTrackerService;
    }

    @PostMapping(produces = "application/json")
    @Override
    public ResponseEntity<String> createProduct(@RequestBody ProductsDTO product) {
        if(product == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        String correlationId = CorrelationIdGenerator.generateCorrelationId("create-product");
        CompletableFuture<String> future = requestTrackerService.registerRequest(correlationId);
        productsKafkaProducer.sendProductData(ObjectsMapper.toProductsEvent(product, "INSERT", correlationId));
        try {
            String status = future.get(timeout , TimeUnit.SECONDS);
            if (status.equals("SUCCESS")) {
                return ResponseEntity.ok("Creating product success");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Creating the product failed");
            }
        } catch (TimeoutException timeoutException) {
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("Gateway timeout");
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request failed");
        }
    }

    @PutMapping(produces = "application/json")
    @Override
    public ResponseEntity<String> updateProduct(@RequestBody ProductsDTO product) {
        if(product == null){
            throw new RuntimeException("No Product data supplied");
        }
        String correlationId = CorrelationIdGenerator.generateCorrelationId("update-product");
        try {
            productsKafkaProducer.sendProductData(ObjectsMapper.toProductsEvent(product, "UPDATE", correlationId));
            return ResponseEntity.ok("Update product event published");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Updating the product failed");
        }
    }
}
