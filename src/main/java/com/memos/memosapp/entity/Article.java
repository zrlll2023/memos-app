package com.memos.memosapp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("article")
public class Article {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;        // 作者ID
    private Long categoryId;    // 分类ID
    private String title;
    private String content;
    private Integer viewCount;

    @TableLogic  // 软删除！查询时自动过滤掉 is_deleted=1 的数据
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}

//package com.memos.memosapp.entity;
//
//import lombok.Data;
//
//@Data
//public class Article {
//    private Long id;
//    private String title;
//    private String content;
//}
