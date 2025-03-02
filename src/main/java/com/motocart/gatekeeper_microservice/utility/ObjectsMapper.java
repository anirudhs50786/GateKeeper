package com.motocart.gatekeeper_microservice.utility;

import com.motocart.gatekeeper_microservice.dto.ProductsDTO;
import com.motocart.gatekeeper_microservice.events.ProductsEvent;

public class ObjectsMapper {

    public static ProductsEvent toProductsEvent(ProductsDTO productsDTO, String eventType, String correlationId){
        return ProductsEvent.builder().eventType(eventType).productsDTO(productsDTO).correlationId(correlationId).build();
    }
}
