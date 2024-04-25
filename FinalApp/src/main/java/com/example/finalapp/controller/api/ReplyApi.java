package com.example.finalapp.controller.api;

import com.example.finalapp.dto.reply.ReplyListDto;
import com.example.finalapp.dto.reply.ReplyUpdateDto;
import com.example.finalapp.dto.reply.ReplyWriteDto;
import com.example.finalapp.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReplyApi {
    private final ReplyService replyService;

    @PostMapping("/v1/boards/{boardId}/reply")
    public void replyWrite(@RequestBody ReplyWriteDto replyWriteDto,
                           @PathVariable("boardId") Long boardId,
                           @SessionAttribute("userId") Long userId){
        replyWriteDto.setBoardId(boardId);
        replyWriteDto.setUserId(userId);
        log.info("replyWriteDto = " + replyWriteDto + ", boardId = " + boardId);

        replyService.registerReply(replyWriteDto);
    }

    @GetMapping("/v1/boards/{boardId}/replies")
    public List<ReplyListDto> replyList(@PathVariable("boardId") Long boardId){
        return replyService.findList(boardId);
    }

    @PatchMapping("/v1/replies/{replyId}")
    public void modifyReply(@RequestBody ReplyUpdateDto replyUpdateDto,
                            @PathVariable("replyId") Long replyId){

        replyService.modifyReply(replyUpdateDto);
        replyService.modifyReply(replyUpdateDto);
    }

    @DeleteMapping("/v1/replies/{replyId}")
    public void removeReply(@PathVariable("replyId") Long replyId){
        replyService.removeReply(replyId);
    }
}
