package com.motocart.gatekeeper_microservice.product.service;

import java.util.List;

public interface CategoriesService {

    String createCategory(String categoryName);

    String updateCategory(int categoryId, String categoryName);

    String deleteCategory(int categoryId);

    List<String> getCategories();

    String getCategory(int categoryId);
}
