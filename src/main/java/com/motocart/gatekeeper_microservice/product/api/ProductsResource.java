package com.motocart.gatekeeper_microservice.product.api;

import com.motocart.library.common.dto.ProductDTO;
import com.motocart.library.common.dto.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductsResource {

    APIResponse<ProductDTO> createProduct(ProductDTO product, MultipartFile productImage) throws Exception;

    ResponseEntity<String> updateProduct(ProductDTO product);

    ResponseEntity<String> deleteProduct(int productId);

    ResponseEntity<String> bulkCreateProducts(List<ProductDTO> products);

    ResponseEntity<String> bulkUpdateProduct(List<ProductDTO> products);

    ResponseEntity<ProductDTO> getProduct(int productId);

    ResponseEntity<List<ProductDTO>> getProducts(int categoryId);

    ResponseEntity<List<ProductDTO>> getProductsByName(String productName);
}
