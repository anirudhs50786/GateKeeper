package com.motocart.gatekeeper_microservice.product.service.impl;

import com.motocart.gatekeeper_microservice.product.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Override
    public String createCategory(String categoryName) {
        // TODO: Add Feign client and implement
        return "Category created successfully";
    }

    @Override
    public String updateCategory(int categoryId, String categoryName) {
        // TODO: Add Feign client and implement
        return "Category updated successfully";
    }

    @Override
    public String deleteCategory(int categoryId) {
        // TODO: Add Feign client and implement
        return "Category deleted successfully";
    }

    @Override
    public List<String> getCategories() {
        // TODO: Add Feign client and implement
        return new ArrayList<>();
    }

    @Override
    public String getCategory(int categoryId) {
        // TODO: Add Feign client and implement
        return null;
    }
}
