package com.example.finalapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class BoardViewDto {
    private Long boardId;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
    private String loginId;
    private Long userId;
}
