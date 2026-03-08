package com.motocart.gatekeeper_microservice.api.impl;

import com.motocart.gatekeeper_microservice.api.CategoriesResource;
import com.motocart.gatekeeper_microservice.service.CategoriesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@Tag(name = "Product Management", description = "Operations related to categories resources")
@Slf4j
public class CategoriesResourceImpl implements CategoriesResource {

    private final CategoriesService categoriesService;

    public CategoriesResourceImpl(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @Override
    public ResponseEntity<String> createCategory(String categoryName) {
        if (categoryName == null || categoryName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category name is required");
        }
        try {
            String responseMessage = categoriesService.createCategory(categoryName);
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (Exception exception) {
            log.error("Error while creating category. {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category creation failed");
        }
    }

    @Override
    public ResponseEntity<String> updateCategory(int categoryId, String categoryName) {
        if (categoryId == 0 || categoryName == null || categoryName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valid category ID and name are required");
        }
        try {
            String responseMessage = categoriesService.updateCategory(categoryId, categoryName);
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (Exception exception) {
            log.error("Error while updating category. {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category update failed");
        }
    }

    @Override
    public ResponseEntity<String> deleteCategory(int categoryId) {
        if (categoryId == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valid category ID is required");
        }
        try {
            String responseMessage = categoriesService.deleteCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (Exception exception) {
            log.error("Error while deleting category. {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category deletion failed");
        }
    }

    @Override
    public ResponseEntity<List<String>> getCategories() {
        try {
            List<String> categories = categoriesService.getCategories();
            return ResponseEntity.status(HttpStatus.OK).body(categories);
        } catch (Exception exception) {
            log.error("Error while fetching categories. {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<String> getCategory(int categoryId) {
        if (categoryId == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valid category ID is required");
        }
        try {
            String category = categoriesService.getCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (Exception exception) {
            log.error("Error while fetching category. {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
