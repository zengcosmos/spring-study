package com.konaqua.mapper;

import com.konaqua.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectByUsername(@Param("username") String username);

    void addUser(@Param("username") String username, @Param("password") String password);

    void updateBalance(@Param("username") String username, @Param("balance") double balance);


}
