package com.example.app.service;

import com.example.app.model.RoleProduct;
import com.example.app.repository.RoleProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleProductServiceImpl implements RoleProductService {
    @Autowired
    private RoleProductRepository repository;

    @Override
    public RoleProduct addRoleProduct(RoleProduct newRoleProduct) {
        return repository.save(newRoleProduct);
    }

    @Override
    public RoleProduct findRoleProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Boolean removeRoleProduct(Integer id) {
        if (repository.findById(id) != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
