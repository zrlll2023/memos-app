package com.memos.memosapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.memos.memosapp.entity.Article;
import java.util.List;

public interface ArticleService extends IService<Article> {
    void publish(Article article, Long userId);  // 发布文章
    List<Article> list(Long categoryId);         // 查询文章列表
}