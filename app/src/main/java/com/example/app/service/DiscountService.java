package com.example.app.service;


import com.example.app.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {
    List<DiscountDTO> findAllListDiscount();
    DiscountDTO findDiscountById(Integer id);
    DiscountDTO addDiscount(DiscountDTO discountDTO);
    boolean removeDiscount(Integer id);
    DiscountDTO updateDiscount(DiscountDTO discountDTO, Integer id);
}
