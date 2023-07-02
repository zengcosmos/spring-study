package com.konaqua.sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MySqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //1.获取SqlSessionFactory
        String resource = "com/konaqua/mapper/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            MySqlSessionFactory.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSqlSession(boolean autoCommit) {
        //2.获取SqlSession
        return sqlSessionFactory.openSession(autoCommit);
    }

    public static SqlSession openSqlSession() {
        //2.获取SqlSession
        return sqlSessionFactory.openSession();
    }
}
