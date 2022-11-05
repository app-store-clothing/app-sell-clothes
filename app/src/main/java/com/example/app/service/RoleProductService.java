package com.example.app.service;


import com.example.app.model.RoleProduct;

public interface RoleProductService {
    RoleProduct addRoleProduct(RoleProduct newRoleProduct);
    RoleProduct findRoleProductById(Integer id);
    Boolean removeRoleProduct(Integer id);
}
