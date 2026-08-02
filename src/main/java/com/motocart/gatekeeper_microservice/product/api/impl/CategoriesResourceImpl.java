package com.motocart.gatekeeper_microservice.product.api.impl;

import com.motocart.gatekeeper_microservice.product.api.CategoriesResource;
import com.motocart.gatekeeper_microservice.product.service.CategoriesService;
import com.motocart.library.common.dto.CategoriesDTO;
import com.motocart.library.common.exception.GlobalException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Override
    public ResponseEntity<CategoriesDTO> createCategory(@RequestBody CategoriesDTO categories) {
        try {
            CategoriesDTO categoriesDTO = categoriesService.createCategory(categories);
            return ResponseEntity.status(HttpStatus.OK).body(categoriesDTO);
        } catch (Exception exception) {
            log.error("Error while creating the category. {}", exception.getMessage());
            throw new GlobalException("Error while creating the category", exception);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<CategoriesDTO> updateCategory(@RequestBody CategoriesDTO requestCategoriesDTO) {
        try {
            CategoriesDTO categoriesDTO = categoriesService.updateCategory(requestCategoriesDTO);
            return ResponseEntity.status(HttpStatus.OK).body(categoriesDTO);
        } catch (Exception exception) {
            log.error("Error while updating the category. {}", exception.getMessage());
            throw new GlobalException("Error while updating the category", exception);
        }
    }

    @DeleteMapping("/{categoryId}")
    @Override
    public ResponseEntity<String> deleteCategory(@RequestParam int categoryId) {
        try {
            categoriesService.deleteCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        } catch (Exception exception) {
            log.error("Error while deleting the category. {}", exception.getMessage());
            throw new GlobalException("Error while deleting the category", exception);
        }
    }

    @GetMapping("/_query")
    @Override
    public ResponseEntity<List<CategoriesDTO>> getCategories() {
        try {
            List<CategoriesDTO> categories = categoriesService.getCategories();
            return ResponseEntity.status(HttpStatus.OK).body(categories);
        } catch (Exception exception) {
            log.error("Error while fetching the categories. {}", exception.getMessage());
            throw new GlobalException("Error while fetching the categories", exception);
        }
    }

    @GetMapping("/{categoryId}")
    @Override
    public ResponseEntity<CategoriesDTO> getCategory(@PathVariable int categoryId) {
        try {
            CategoriesDTO category = categoriesService.getCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (IllegalArgumentException exception) {
            log.warn("Incorrect category Id given. {}", exception.getMessage());
            throw new GlobalException("Incorrect category Id given", exception);
        } catch (Exception exception) {
            log.error("Error while fetching the category for the id. {}", exception.getMessage());
            throw new GlobalException("Error while fetching the category for the id", exception);
        }
    }
}
