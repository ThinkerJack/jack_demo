package dao;

import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    public List<User> findAll();
}
