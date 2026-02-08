package com.motocart.gatekeeper_microservice.api.rest.impl;

import com.motocart.gatekeeper_microservice.api.rest.CategoriesResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@Tag(name = "Product Management", description = "Operations related to categories resources")
@Slf4j
public class CategoriesResourceImpl implements CategoriesResource {

    @Override
    public ResponseEntity<String> createCategory(String categoryName) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateCategory(int categoryId, String categoryName) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCategory(int categoryId) {
        return null;
    }

    @Override
    public ResponseEntity<List<String>> getCategories() {
        return null;
    }

    @Override
    public ResponseEntity<String> getCategory(int categoryId) {
        return null;
    }
}
