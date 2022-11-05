package com.example.app.model;


import com.example.app.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    private Integer size;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_storage_id", nullable = false)
    private ImageStorage imageStorage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleProduct", nullable = false)
    private RoleProduct roleProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discount")
    private Discount discount;

    public static Product from(ProductDTO productDTO) {
        Product product = new Product();
        if (product.getId() != null) {
            product.setId(productDTO.getId());
        }
        product.setProductName(productDTO.getProductName());
        product.setRoleProduct(productDTO.getRoleProduct());
        product.setPrice(productDTO.getPrice());
        product.setSize(productDTO.getSize());
        product.setImageStorage(productDTO.getImageStorage());
        product.setRoleProduct(productDTO.getRoleProduct());
        product.setDiscount(productDTO.getDiscount());
        return product;

    }

}

