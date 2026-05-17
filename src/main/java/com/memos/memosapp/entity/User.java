package com.memos.memosapp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")  // 告诉 MyBatisPlus 这个类对应数据库的 user 表
public class User {

    @TableId(type = IdType.AUTO)  // 主键，自增
    private Long id;

    private String username;
    private String password;
    private String avatar;

    @TableField(fill = FieldFill.INSERT)  // 插入时自动填充时间
    private LocalDateTime createTime;
}
//package com.memos.memosapp.entity;
//
//import lombok.Data;
//import java.time.LocalDateTime;
//
//@Data  // 自动生成 getter/setter
//public class User {
//    private Long id;
//    private String username;
//    private String password;
//    private String avatar;
//    private LocalDateTime createTime;
//}