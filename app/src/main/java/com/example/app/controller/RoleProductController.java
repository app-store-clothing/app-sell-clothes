package com.example.app.controller;

import com.example.app.model.RoleProduct;
import com.example.app.service.RoleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/roleProduct")
public class RoleProductController  {

    @Autowired
    private RoleProductService service;

    @PostMapping("/addRoleProduct")
    public ResponseEntity<RoleProduct> addRoleProduct(@RequestBody RoleProduct newRoleProduct) {
        return new ResponseEntity(service.addRoleProduct(newRoleProduct), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRoleProduct(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity(service.removeRoleProduct(id), HttpStatus.OK);
    }

}
