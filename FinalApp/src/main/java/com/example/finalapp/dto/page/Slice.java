package com.example.finalapp.dto.page;

import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Slice<T> {
    boolean hasNext;
    List<T> contentList;

}
