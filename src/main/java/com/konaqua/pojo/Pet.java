package com.konaqua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private Integer pet_id;
    private String name;
    private String description;
    private double price;
    private String pet_class;
    private boolean has_sold_out;
}
