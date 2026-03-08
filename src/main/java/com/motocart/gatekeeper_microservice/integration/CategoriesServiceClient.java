package com.motocart.gatekeeper_microservice.integration;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "products-server", path = "/closedcart/api/categories")
public interface CategoriesServiceClient {

}
