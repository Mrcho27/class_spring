package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(CommentDto commentDto);

    CommentDto selectComment(Long commentId);

    List<CommentDto> selectAll();

    void updateComment(CommentDto commentDto);

    void deleteComment(Long commentId);
}
