package com.memos.memosapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.memos.memosapp.entity.Comment;
import com.memos.memosapp.mapper.CommentMapper;
import com.memos.memosapp.service.CommentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public void addComment(Long articleId, String content, Long userId) {
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setContent(content);
        comment.setUserId(userId);
        this.save(comment);
    }

    @Override
    public List<Comment> listByArticle(Long articleId) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<Comment>()
                .eq(Comment::getArticleId, articleId)
                .orderByDesc(Comment::getCreateTime);
        return this.list(wrapper);
    }
}