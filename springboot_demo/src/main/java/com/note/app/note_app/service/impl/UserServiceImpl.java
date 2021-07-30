package com.note.app.note_app.service.impl;


import com.note.app.note_app.dao.UserDao;
import com.note.app.note_app.entity.User;
import com.note.app.note_app.service.UserService;
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
