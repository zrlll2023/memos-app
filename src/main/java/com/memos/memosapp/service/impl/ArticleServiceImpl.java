package com.memos.memosapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.memos.memosapp.entity.Article;
import com.memos.memosapp.mapper.ArticleMapper;
import com.memos.memosapp.service.ArticleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public void publish(Article article, Long userId) {
        article.setUserId(userId);      // 设置作者
        article.setViewCount(0);        // 初始浏览量为0
        this.save(article);             // 存入数据库
    }

    @Override
    public List<Article> list(Long categoryId) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<Article>()
                .eq(categoryId != null, Article::getCategoryId, categoryId)
                .orderByDesc(Article::getCreateTime);  // 按时间倒序
        return this.list(wrapper);
    }
}