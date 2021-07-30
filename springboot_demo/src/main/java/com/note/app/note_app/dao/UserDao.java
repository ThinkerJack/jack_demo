package com.note.app.note_app.dao;


import com.note.app.note_app.entity.User;

import java.util.List;


public interface UserDao {
    /**
     * 查询所有用户
     * @return List<User> 用户集合
     */
    List<User> selectUser();
}
