package com.konaqua.mapper;

import com.konaqua.pojo.Transaction;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TransactionMapper {
    @Select("select transaction_id, pet_id, purchase_username, sell_username, transaction_date from tb_transaction;")
    List<Transaction> selectAll();
}
