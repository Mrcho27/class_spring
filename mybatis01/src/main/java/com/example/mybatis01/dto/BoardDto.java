package com.example.mybatis01.dto;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
public class BoardDto {
    private Long boardId;
    private String title;
    private String content;
    private String writer;
}
