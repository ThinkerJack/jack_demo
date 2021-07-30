package com.springboot.demo.test_app.service;


import com.springboot.demo.test_app.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 测试连接数据库
     * @return List<User> 用户集合
     */
     List<User> testConnectDb();
}
