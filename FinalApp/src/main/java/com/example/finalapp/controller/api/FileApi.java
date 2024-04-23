package com.example.finalapp.controller.api;

import com.example.finalapp.dto.file.FileDto;
import com.example.finalapp.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileApi {
    public final FileService fileService;

    @Value("${file.dir}")
    private String fileDir;

    /*
    RESTful
    문서, 이미지, 데이터 등등의 자원을 이름으로 구분하여 데이터를 주고받는 스타일을 의미한다. (일종의 약속)
    이때 주고받는 데이터의 형식은 JSON, XML 등을 사용한다.

    예를 들어 댓글에 대한 정보를 DB에서 가져와야하는 상황이라면 필요한 자원이 댓글이다.
    이 자원의 이름을 복수형으로 사용하여 URL에 사용한다.
    이때 무엇을 할 것인지는 HTTP Method를 이용하여 구분한다.

    예) GET : /replies/list. DELETE : /replies/{댓글번호}
    CRUD 별 HTTP Method
    - Create : 삽입(POST)
    - Read : 조회 (GET)
    - Update : 수정(PUT, PATCH)
        * PUT : 전체 수정
        * PATCH : 부분 수정
    - Delete : 삭제(DELETE)

    정리하자면 REST란 자원을 중점으로 직관적인 URL과 HTTP Method를 사용하여 웹서비스를 제공하는 것을 의미한다.
    이렇게 REST라는 규칙을 지켜서 만든 웹 서비스를 RESTful웹 서비스 라고 부른다.
     */

    @GetMapping("/v1/boards/{boardId}/files")
    public List<FileDto> fileList(@PathVariable("boardId") Long boardId){
        return fileService.findList(boardId);
    }

    @GetMapping("/v1/files")
    public byte[] display(String fileName) throws IOException {
        File file = new File(fileDir,fileName);

        return FileCopyUtils.copyToByteArray(file);
    }
}
