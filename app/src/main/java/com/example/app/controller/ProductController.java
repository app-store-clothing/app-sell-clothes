package com.example.app.controller;

import com.example.app.dto.ProductDTO;
import com.example.app.model.RoleProduct;
import com.example.app.service.ProductService;
import com.example.app.service.RoleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private RoleProductService roleProductService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return new ResponseEntity(service.findAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/getByRole/{idRole}")
    public ResponseEntity<List<ProductDTO>> getProductByRoleProduct(@PathVariable(name = "idRole") Integer idRole) {
        RoleProduct role = roleProductService.findRoleProductById(idRole);
        return new ResponseEntity(service.findProductByRoleProduct(role), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(service.findProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO newProduct) {
        return new ResponseEntity(service.addProduct(newProduct), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @RequestBody ProductDTO updateProduct,
            @PathVariable(name = "id") Integer id) {
        return new ResponseEntity(service.updateProduct(updateProduct, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity(service.removeProduct(id), HttpStatus.OK);
    }
}
