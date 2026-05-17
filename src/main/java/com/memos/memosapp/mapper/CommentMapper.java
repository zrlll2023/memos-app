package com.memos.memosapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.memos.memosapp.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}