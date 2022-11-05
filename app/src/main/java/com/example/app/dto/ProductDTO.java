package com.example.app.dto;

import com.example.app.model.Discount;
import com.example.app.model.ImageStorage;
import com.example.app.model.Product;
import com.example.app.model.RoleProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String productName;
    private String description;
    private Integer price;
    private Integer size;
    private ImageStorage imageStorage;
    private RoleProduct roleProduct;
    private Discount discount;

    public static ProductDTO from(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setDescription(product.getDescription());
        productDTO.setSize(product.getSize());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageStorage(product.getImageStorage());
        productDTO.setRoleProduct(product.getRoleProduct());
        productDTO.setDiscount(product.getDiscount());
        return productDTO;
    }
}
