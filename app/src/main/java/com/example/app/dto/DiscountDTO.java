package com.example.app.dto;

import com.example.app.model.Discount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
    private Integer id;
    private float discountValue;
    private Date timeStart;
    private Integer timeDuring;

    public static DiscountDTO from(Discount discount) {
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setId(discount.getId());
        discountDTO.setDiscountValue(discountDTO.getDiscountValue());
        discountDTO.setTimeStart(discountDTO.getTimeStart());
        discountDTO.setTimeDuring(discountDTO.getTimeDuring());
        return discountDTO;
    }
}
