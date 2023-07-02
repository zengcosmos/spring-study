package com.konaqua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Transaction {
    private Integer transaction_id;
    private Integer pet_id;
    private String purchase_username;
    private String sell_username;
    private LocalDate transaction_date;
}
