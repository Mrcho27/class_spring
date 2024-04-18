package com.example.finalapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class BoardListDto {
    private Long boardId;
    private String title;
    private String loginId;
}
