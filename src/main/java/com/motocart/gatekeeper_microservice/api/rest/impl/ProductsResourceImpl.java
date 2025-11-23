package com.motocart.gatekeeper_microservice.api.rest.impl;

import com.motocart.gatekeeper_microservice.api.rest.ProductsResource;
import com.motocart.gatekeeper_microservice.dto.ProductDTO;
import com.motocart.gatekeeper_microservice.service.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
@Tag(name = "Product Management", description = "Operations related to products resources")
@Slf4j
public class ProductsResourceImpl implements ProductsResource {

    private final ProductsService productsService;

    public ProductsResourceImpl(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping(produces = "application/json")
    @Operation(description = "Creates a new product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product creation was successful"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to create the product")
    })
    @Override
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO product) {
        if(product == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        try {
            String responseMessage = productsService.createProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        }
        catch (Exception exception) {
            log.error("Error while creating the product. {}", exception.getMessage());
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
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO product) {
        if(product == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        try {
            String responseMessage = productsService.updateProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (Exception exception) {
            log.error("Error while updating the product. {}", exception.getMessage());
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
        } catch (Exception exception) {
            log.error("Error while deleting the product. {}", exception.getMessage());
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
    public ResponseEntity<String> bulkCreateProducts(@RequestBody List<ProductDTO> products) {
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
    public ResponseEntity<String> bulkUpdateProduct(@RequestBody List<ProductDTO> products) {
        if(products == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product data supplied");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Update product event published");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Updating the product failed");
        }
    }

    @GetMapping
    @Operation(description = "Fetches the product for the product id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product successfully retrieved for the product id"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to fetch the product for the product id")
    })
    @Override
    public ResponseEntity<ProductDTO> getProduct(@RequestParam int productId) {
        ProductDTO productDTO = null;
        if(productId == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        }
        catch (Exception exception) {
            log.error("Error while fetching the product. {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productDTO);
        }
    }

    @GetMapping
    @Operation(description = "Fetches the list of product for the category id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product list successfully retrieved for the category id"),
            @ApiResponse(responseCode = "400", description = "Bad request provided"),
            @ApiResponse(responseCode = "500", description = "Failed to fetch the product list for the category id")
    })
    @Override
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam int categoryId) {
        List<ProductDTO> productDTO = new ArrayList<>();
        if(categoryId == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        }
        catch (Exception exception) {
            log.error("Error while fetching the product list. {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productDTO);
        }
    }
}
