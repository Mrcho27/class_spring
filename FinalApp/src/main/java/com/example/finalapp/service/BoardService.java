package com.example.finalapp.service;

import com.example.finalapp.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
}
