package com.example.app.service;


import com.example.app.dto.ProductDTO;
import com.example.app.model.RoleProduct;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProduct();
    List<ProductDTO> findProductByRoleProduct(RoleProduct roleProduct);
    ProductDTO findProductById(Integer id);
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO, Integer id);
    Boolean removeProduct(Integer id);
}
