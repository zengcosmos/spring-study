package com.konaqua.controller;

import com.konaqua.mapper.UserMapper;
import com.konaqua.pojo.User;
import com.konaqua.sql.MySqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/addUser")
    public String add(String username, String password) {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(username, password);
        sqlSession.commit();
        sqlSession.close();
        return "OK";
    }

    @RequestMapping("/selectUserByUsername")
    public User selectByUsername(String username) {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByUsername(username);
        sqlSession.close();
        return user;
    }

    @RequestMapping("/selectAllUsers")
    public List<User> selectAll() {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        sqlSession.close();
        return users;
    }

    @RequestMapping("/updateUserBalance")
    public String updateBalance(String username, Double balance) {
        SqlSession sqlSession = MySqlSessionFactory.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateBalance(username, balance);
        sqlSession.commit();
        sqlSession.close();
        return "OK";
    }
}
