package com.example.finalapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString//(exclude = {"title","content"})
@NoArgsConstructor
public class BoardUpdateDto {
    private Long boardId;
    private String title;
    private String content;
}
