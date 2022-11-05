package com.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_product")
public class RoleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String productRoleName;

    @OneToMany(mappedBy = "roleProduct", fetch = FetchType.EAGER)
    private List<Product> products;

    public List<Product> getProduct() {
        return products;
    }

}
