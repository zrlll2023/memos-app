package com.memos.memosapp.controller;

import com.memos.memosapp.common.Result;
import com.memos.memosapp.entity.Comment;
import com.memos.memosapp.service.CommentService;
import com.memos.memosapp.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 发表评论（需要登录）
    @PostMapping
    public Result<?> add(@RequestParam Long articleId,
                         @RequestParam String content) {
        Long userId = UserContext.getUserId();
        commentService.addComment(articleId, content, userId);
        return Result.success("评论成功");
    }

    // 查询某篇文章的评论列表（不需要登录）
    @GetMapping("/list")
    public Result<List<Comment>> list(@RequestParam Long articleId) {
        List<Comment> comments = commentService.listByArticle(articleId);
        return Result.success(comments);
    }
}