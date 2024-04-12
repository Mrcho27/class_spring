package com.example.task01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class BoardDto {
    private Long boardId;
    private String title;
    private String content;
    private Long userId;
}
