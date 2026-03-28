package com.motocart.gatekeeper_microservice.inventory.warehouse.api;

import com.motocart.library.common.dto.WarehouseDTO;
import org.springframework.http.ResponseEntity;

public interface WarehouseResource {

    ResponseEntity<String> addWarehouse(WarehouseDTO warehouseDTO);

    ResponseEntity<String> updateWarehouse(WarehouseDTO warehouseDTO);

    ResponseEntity<String> deleteWarehouse(int warehouseId);
}

