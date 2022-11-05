package com.example.app.repository;

import com.example.app.model.Product;
import com.example.app.model.RoleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByRoleProduct(RoleProduct roleProduct);
}
