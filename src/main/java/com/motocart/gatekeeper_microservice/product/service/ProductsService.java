package com.motocart.gatekeeper_microservice.product.service;

import com.motocart.library.common.dto.ProductDTO;

import java.util.List;

public interface ProductsService {

    String createProduct(ProductDTO productDTO);

    String updateProduct(ProductDTO productDTO);

    List<ProductDTO> getProductByName(String productName);

    String deleteProduct(int productId);

    String bulkCreateProducts(List<ProductDTO> products);

    String bulkUpdateProduct(List<ProductDTO> products);

    ProductDTO getProduct(int productId);

    List<ProductDTO> getProducts(int categoryId);
}
