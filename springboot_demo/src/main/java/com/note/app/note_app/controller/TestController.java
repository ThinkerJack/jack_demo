package com.note.app.note_app.controller;

import com.note.app.note_app.dao.UserDao;
import com.note.app.note_app.entity.User;
import com.note.app.note_app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "测试接口")
@Controller
@RequestMapping("test")
@Repository
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    /**
     * 测试启动
     * @return 启动成功信息 String
     */
    @ApiOperation("测试启动")
    @GetMapping("/run")
    @ResponseBody
    public String testRun() {
        return "你的服务启动成功了";
    }

    /**
     * 测试连接数据库
     * @return List<User> 用户集合
     */
    @ApiOperation("测试连接数据库")
    @GetMapping("/connectDb")
    @ResponseBody
    public List<User> testConnectDb() {
        return userService.testConnectDb();
    }
}
