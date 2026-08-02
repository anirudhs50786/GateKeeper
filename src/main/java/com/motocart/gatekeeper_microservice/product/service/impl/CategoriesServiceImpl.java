package com.motocart.gatekeeper_microservice.product.service.impl;

import com.motocart.gatekeeper_microservice.product.integration.CategoriesServiceClient;
import com.motocart.gatekeeper_microservice.product.service.CategoriesService;
import com.motocart.library.common.dto.CategoriesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesServiceClient categoriesServiceClient;

    public CategoriesServiceImpl(CategoriesServiceClient categoriesServiceClient) {
        this.categoriesServiceClient = categoriesServiceClient;
    }

    @Override
    public CategoriesDTO createCategory(CategoriesDTO category) {
        return categoriesServiceClient.createCategory(category).getBody();
    }

    @Override
    public CategoriesDTO updateCategory(CategoriesDTO requestCategoriesDTO) {
        return categoriesServiceClient.updateCategory(requestCategoriesDTO).getBody();
    }

    @Override
    public String deleteCategory(int categoryId) {
        return categoriesServiceClient.deleteCategory(categoryId).getBody();
    }

    @Override
    public List<CategoriesDTO> getCategories() {
        return categoriesServiceClient.getCategories().getBody();
    }

    @Override
    public CategoriesDTO getCategory(int categoryId) {
        return categoriesServiceClient.getCategory(categoryId).getBody();
    }
}
