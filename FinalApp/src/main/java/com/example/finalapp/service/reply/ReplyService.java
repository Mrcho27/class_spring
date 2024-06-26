package com.example.finalapp.service.reply;

import com.example.finalapp.dto.page.Criteria;
import com.example.finalapp.dto.page.Slice;
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
    public void removeReply(Long replyId){
        replyMapper.deleteReply(replyId);
    }

    public Slice<ReplyListDto> findSlice(Criteria criteria, Long boardId){
        List<ReplyListDto> replyList = replyMapper.selectSlice(criteria,boardId);

        boolean hasNext = replyList.size() > criteria.getAmount();

        if(hasNext){
            replyList.remove(criteria.getAmount());
        }


        //TODO 2024-04-26 csh: Slice 클래스를 생성하여 list와 hasNext를 저장할 수 있는 필드를 만들어준다.
        //  해당 객체에 list와 hasNext를 저장하고 여기서 반환해준다.
        return new Slice<ReplyListDto>(hasNext, replyList);
    }


}
