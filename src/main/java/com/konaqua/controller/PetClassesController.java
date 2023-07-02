package com.konaqua.controller;

import com.konaqua.mapper.PetClassesMapper;
import com.konaqua.pojo.PetClass;
import com.konaqua.sql.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetClassesController {

    @RequestMapping("/addPetClass")
    public String add(String pet_class) {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        PetClassesMapper petClassesMapper = sqlSession.getMapper(PetClassesMapper.class);
        petClassesMapper.addPetClass(pet_class);
        sqlSession.commit();
        sqlSession.close();
        return "OK";
    }

    @RequestMapping("/selectAllPetClasses")
    public List<PetClass> selectAll() {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        PetClassesMapper petClassesMapper = sqlSession.getMapper(PetClassesMapper.class);
        List<PetClass> petClasses = petClassesMapper.selectAll();
        sqlSession.close();
        return petClasses;
    }
}
