package com.memos.memosapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.memos.memosapp.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    // 和 UserMapper 一样，什么都不用写
}