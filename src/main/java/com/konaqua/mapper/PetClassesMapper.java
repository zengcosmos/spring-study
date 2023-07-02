package com.konaqua.mapper;

import com.konaqua.pojo.PetClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PetClassesMapper {

    @Select("select pet_class_id, pet_class from tb_pet_classes;")
    List<PetClass> selectAll();

    @Insert("insert into tb_pet_classes (pet_class) VALUES (#{pet_class});")
    void addPetClass(@Param("pet_class") String pet_class);

}
