package com.memos.memosapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.memos.memosapp.entity.User;

public interface UserService extends IService<User> {
    // 今天先定义两个方法
    String register(String username, String password);  // 返回提示信息
    String login(String username, String password);     // 返回 Token
}