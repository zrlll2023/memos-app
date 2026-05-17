package com.memos.memosapp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("comment")
public class Comment {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long articleId;   // 评论的文章
    private Long userId;      // 评论的用户
    private String content;   // 评论内容

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}