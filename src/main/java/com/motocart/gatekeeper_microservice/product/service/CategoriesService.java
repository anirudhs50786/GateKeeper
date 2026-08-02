package com.motocart.gatekeeper_microservice.product.service;

import com.motocart.library.common.dto.CategoriesDTO;

import java.util.List;

public interface CategoriesService {

    CategoriesDTO createCategory(CategoriesDTO category);

    CategoriesDTO updateCategory(CategoriesDTO requestCategoriesDTO);

    String deleteCategory(int categoryId);

    List<CategoriesDTO> getCategories();

    CategoriesDTO getCategory(int categoryId);
}
