package com.example.app.service;

import com.example.app.dto.DiscountDTO;
import com.example.app.model.Discount;
import com.example.app.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<DiscountDTO> findAllListDiscount() {
        return discountRepository.findAll().stream().map(DiscountDTO::from).collect(Collectors.toList());
    }

    @Override
    public DiscountDTO findDiscountById(Integer id) {
       Discount discount = discountRepository.findById(id).orElse(null);
       if (discount != null) {
           return DiscountDTO.from(discount);
       }
       return null;
    }

    @Override
    public DiscountDTO addDiscount(DiscountDTO discountDTO) {
        discountRepository.save(Discount.from(discountDTO));
        return discountDTO;
    }

    @Override
    public boolean removeDiscount(Integer id) {
        if (discountRepository.findById(id) == null) {
            return false;
        } else {
            discountRepository.deleteById(id);
            return true;
        }

    }

    @Override
    public DiscountDTO updateDiscount(DiscountDTO discountDTO, Integer id) {
        Discount curDiscount = discountRepository.findById(id).orElse(null);
        curDiscount = Discount.from(discountDTO);
        discountRepository.save(curDiscount);
        return discountDTO;
    }
}
