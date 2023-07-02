package com.konaqua.mapper;

import com.konaqua.pojo.Pet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PetMapper {

    @Select("select pet_id, sell_username, description, price, pet_class, has_sold_out from tb_pet;")
    List<Pet> selectAll();

    @Insert("insert into tb_pet (sell_username, description, price, pet_class) VALUES (#{sell_username}, #{description}, #{price} , #{pet_class});")
    void add(@Param("sell_username") String sell_username, @Param("description") String description,
             @Param("price") double price, @Param("pet_class") String pet_class);
}
