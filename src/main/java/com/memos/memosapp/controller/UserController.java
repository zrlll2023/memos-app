package com.memos.memosapp.controller;

import com.memos.memosapp.common.Result;
import com.memos.memosapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor  // Lombok：自动生成构造函数，实现依赖注入
public class UserController {

    private final UserService userService;  // 注入 Service

    @PostMapping("/register")
    public Result<String> register(@RequestParam String username,
                                   @RequestParam String password) {
        String result = userService.register(username, password);
        return Result.success(result);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestParam String username,
                                @RequestParam String password) {
        String result = userService.login(username, password);
        return Result.success(result);
    }
}