package com.memos.memosapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.memos.memosapp.entity.User;
import com.memos.memosapp.mapper.UserMapper;
import com.memos.memosapp.service.UserService;
import com.memos.memosapp.utils.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service  // 告诉 Spring 这是一个 Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String register(String username, String password) {
        // 1. 检查用户名是否已存在
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User existing = this.getOne(wrapper);
        if (existing != null) {
            return "用户名已存在";
        }

        // 2. 密码加密后存入数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));  // 加密！
        this.save(user);  // MyBatisPlus 的 save()，直接插入数据库

        return "注册成功";
    }

    @Override
    public String login(String username, String password) {
        // 1. 根据用户名查用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = this.getOne(wrapper);

        // 2. 用户不存在
        if (user == null) {
            return "用户名不存在";
        }

        // 3. 验证密码（BCrypt 验证）
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "密码错误";
        }

        // 今天先返回简单字符串，明天换成真正的 JWT Token
        //把这行
        // return "登录成功，用户ID：" + user.getId();

        // 换成这行
        return JwtUtil.generateToken(user.getId(), user.getUsername());
    }
}