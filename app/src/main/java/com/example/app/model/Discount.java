package com.example.app.model;

import com.example.app.dto.DiscountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float discountValue;
    private Date timeStart;
    private Integer timeDuring;

    public static Discount from(DiscountDTO discountDTO) {
        Discount discount = new Discount();
        if (discountDTO.getId()!=null) {
            discount.setId(discountDTO.getId());
        }
        discount.setDiscountValue(discountDTO.getDiscountValue());
        discount.setTimeStart(discountDTO.getTimeStart());
        discount.setTimeDuring(discountDTO.getTimeDuring());
        return discount;
    }
}
