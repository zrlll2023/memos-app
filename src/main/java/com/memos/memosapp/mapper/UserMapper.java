package com.memos.memosapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.memos.memosapp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper  // 告诉 Spring 这是一个 Mapper
public interface UserMapper extends BaseMapper<User> {
    // 不用写任何代码！
    // 继承 BaseMapper 之后自动拥有：
    // insert() / deleteById() / updateById() / selectById() / selectList() 等方法
}