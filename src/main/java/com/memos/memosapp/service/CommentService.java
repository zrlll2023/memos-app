package com.memos.memosapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.memos.memosapp.entity.Comment;
import java.util.List;

public interface CommentService extends IService<Comment> {
    void addComment(Long articleId, String content, Long userId);
    List<Comment> listByArticle(Long articleId);
}