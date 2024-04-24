package com.example.finalapp.service.reply;

import com.example.finalapp.dto.reply.ReplyListDto;
import com.example.finalapp.dto.reply.ReplyUpdateDto;
import com.example.finalapp.dto.reply.ReplyWriteDto;
import com.example.finalapp.mapper.reply.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyMapper replyMapper;

    public void registerReply(ReplyWriteDto replyWriteDto){
        replyMapper.insertReply(replyWriteDto);
    }
    public List<ReplyListDto> findList(Long boardId){
       return replyMapper.selectList(boardId);
    }
    public void modifyReply(ReplyUpdateDto replyUpdateDto){
        replyMapper.updateReply(replyUpdateDto);
    }
    public void removeReply(Long boardId){
        replyMapper.deleteReply(boardId);
    }


}
