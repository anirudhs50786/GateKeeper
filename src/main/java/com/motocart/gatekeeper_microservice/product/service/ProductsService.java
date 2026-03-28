package com.motocart.gatekeeper_microservice.product.service;

import com.motocart.library.common.dto.ProductDTO;
import com.motocart.library.common.dto.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductsService {

    APIResponse<ProductDTO> createProduct(ProductDTO productDTO, MultipartFile productImage);

    String updateProduct(ProductDTO productDTO);

    List<ProductDTO> getProductByName(String productName);

    String deleteProduct(int productId);

    String bulkCreateProducts(List<ProductDTO> products);

    String bulkUpdateProduct(List<ProductDTO> products);

    ProductDTO getProduct(int productId);

    List<ProductDTO> getProducts(int categoryId);
}
