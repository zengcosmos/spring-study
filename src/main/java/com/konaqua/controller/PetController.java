package com.konaqua.controller;

import com.konaqua.mapper.PetMapper;
import com.konaqua.pojo.Pet;
import com.konaqua.sql.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    @RequestMapping("/selectAllPets")
    public List<Pet> selectAll() {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        PetMapper petMapper = sqlSession.getMapper(PetMapper.class);
        List<Pet> pets = petMapper.selectAll();
        sqlSession.close();
        return pets;
    }

    @RequestMapping("/addPet")
    public String add(String sell_username, String description, double price, String pet_class) {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        PetMapper petMapper = sqlSession.getMapper(PetMapper.class);
        petMapper.add(sell_username, description, price, pet_class);
        sqlSession.commit();
        sqlSession.close();
        return "OK";
    }
}
