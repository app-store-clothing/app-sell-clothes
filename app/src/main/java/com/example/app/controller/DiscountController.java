package com.example.app.controller;

import com.example.app.dto.DiscountDTO;
import com.example.app.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/discount")
public class DiscountController {
    @Autowired
    private DiscountService service;
    
    @PostMapping
    public ResponseEntity<DiscountDTO> addDiscount(@RequestBody DiscountDTO newDiscount) {
        return new ResponseEntity(service.addDiscount(newDiscount), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDiscount(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity(service.removeDiscount(id), HttpStatus.OK);
    }
}
