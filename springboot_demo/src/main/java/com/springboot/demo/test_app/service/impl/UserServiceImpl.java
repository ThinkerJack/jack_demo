package com.springboot.demo.test_app.service.impl;


import com.springboot.demo.test_app.dao.UserDao;
import com.springboot.demo.test_app.entity.User;
import com.springboot.demo.test_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     * 测试连接数据库
     * @return List<User> 用户集合
     */
    @Override
    public List<User> testConnectDb() {
        return userDao.selectUser();
    }

}
