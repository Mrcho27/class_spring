package com.example.mybatis01.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long commentId;
    private String content;
    private String writer;
}
