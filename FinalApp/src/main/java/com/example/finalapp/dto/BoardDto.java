package com.example.finalapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString//(exclude = {"title","content"})
@NoArgsConstructor
public class BoardDto {
    private Long boardId;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
}
