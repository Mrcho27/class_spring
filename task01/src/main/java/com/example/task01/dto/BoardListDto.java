package com.example.task01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class BoardListDto {
    private Long boardId;
    private Long userId;
    private String title;
    private String loginId;
}
