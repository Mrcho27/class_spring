package com.example.mybatis01.mapper;

import com.example.mybatis01.dto.CommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentMapperTest {
    @Autowired
    CommentMapper commentMapper;

    @Test
    void insertComment() {
        CommentDto commentDto = new CommentDto();

        commentDto.setContent("new content22");
        commentDto.setWriter("new writer22");
       commentMapper.insertComment(commentDto);
    }

    @Test
    void selectComment() {
        CommentDto selectComment = commentMapper.selectComment(1L);
        System.out.println("selectComment = " + selectComment);
    }

    @Test
    void selectAll() {
        List<CommentDto> commentDtoList = commentMapper.selectAll();
        System.out.println("commentDtoList = " + commentDtoList);

    }

    @Test
    void updateComment() {
        CommentDto commentDto = new CommentDto();
        commentDto.setCommentId(1L);
        commentDto.setContent("change");
        commentDto.setWriter("change writer");
        commentMapper.updateComment(commentDto);
    }

    @Test
    void deleteComment() {
        commentMapper.deleteComment(1L);
    }
}