package com.motocart.gatekeeper_microservice.producer;

import com.motocart.gatekeeper_microservice.events.ProductsEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductsKafkaProducer {

    private final KafkaTemplate<String, ProductsEvent> productsKafkaTemplate;

    public ProductsKafkaProducer(KafkaTemplate<String, ProductsEvent> productsKafkaTemplate) {
        this.productsKafkaTemplate = productsKafkaTemplate;
    }

    public void sendProductData(ProductsEvent productsEvent) {
        log.info("sending product data");
        productsKafkaTemplate.send("products-events", productsEvent.getEventType(), productsEvent);
    }
}
