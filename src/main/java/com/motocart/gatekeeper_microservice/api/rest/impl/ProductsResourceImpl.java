package com.motocart.gatekeeper_microservice.api.rest.impl;

import com.motocart.gatekeeper_microservice.api.rest.ProductsResource;
import com.motocart.gatekeeper_microservice.dto.ProductsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@Tag(name = "Employee Management", description = "Operations related to products resources")
@Slf4j
public class ProductsResourceImpl implements ProductsResource {

    @PostMapping(produces = "application/json")
    @Operation(description = "Creates a new product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product creation was successful"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to create the product")
    })
    @Override
    public ResponseEntity<String> createProduct(@RequestBody ProductsDTO product) {
        if(product == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Request Success");
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product create request failed");
        }
    }

    @PutMapping(produces = "application/json")
    @Operation(description = "Updates an existing product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product update was successful"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to update the product")
    })
    @Override
    public ResponseEntity<String> updateProduct(@RequestBody ProductsDTO product) {
        if(product == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Update product event published");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Updating the product failed");
        }
    }

    @DeleteMapping(produces = "application/json")
    @Operation(description = "Deletes the product data")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Deletion of product was successful"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to delete the product")
    })
    @Override
    public ResponseEntity<String> deleteProduct(@RequestParam int productId) {
        if(productId == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide a valid product");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Update product event published");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Updating the product failed");
        }
    }

    @PostMapping(path = "/bulk", produces = "application/json")
    @Operation(description = "Creates new products in bulk")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Bulk product creation was successful"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to create the products")
    })
    @Override
    public ResponseEntity<String> bulkCreateProducts(@RequestBody List<ProductsDTO> products) {
        if(products == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Bulk Products create request success");
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bulk Products create request failed");
        }
    }

    @PutMapping(path = "/bulk", produces = "application/json")
    @Operation(description = "Updates the existing products in bulk")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Bulk update of products was successful"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to update the products")
    })
    @Override
    public ResponseEntity<String> bulkUpdateProduct(@RequestBody ProductsDTO product) {
        if(product == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Update product event published");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Updating the product failed");
        }
    }
}
