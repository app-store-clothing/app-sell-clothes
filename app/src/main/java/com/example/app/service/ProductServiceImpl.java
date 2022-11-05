package com.example.app.service;

import com.example.app.dto.ProductDTO;
import com.example.app.model.Product;
import com.example.app.model.RoleProduct;
import com.example.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllProduct() {
        return productRepository.findAll().stream().map(ProductDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findProductByRoleProduct(RoleProduct roleProduct) {
        return productRepository.findProductByRoleProduct(roleProduct)
                                    .stream()
                                    .map(ProductDTO::from)
                                    .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductById(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return ProductDTO.from(product);
        }
        return null;
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        productRepository.save(Product.from(productDTO));
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Integer id) {
        Product curProduct = productRepository.findById(id).orElse(null);
        if (curProduct != null) {
            curProduct = Product.from(productDTO);
            productRepository.save(curProduct);
            return productDTO;
        }
        return null;
    }

    @Override
    public Boolean removeProduct(Integer id) {
        if (productRepository.findById(id) != null) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
