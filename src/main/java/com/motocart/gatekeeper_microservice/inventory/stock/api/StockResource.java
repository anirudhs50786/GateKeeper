package com.motocart.gatekeeper_microservice.inventory.stock.api;

import com.motocart.library.common.dto.StockDTO;
import org.springframework.http.ResponseEntity;

public interface StockResource {

    ResponseEntity<String> addStock(StockDTO stockDTO);

    ResponseEntity<String> updateStock(StockDTO stockDTO);

    ResponseEntity<StockDTO> checkStock(int productId);
}

