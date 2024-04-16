package com.study.ex15readdbcrud.service;

import com.study.ex15readdbcrud.domain.reply.Reply;
import com.study.ex15readdbcrud.domain.reply.ReplyRepository;
import com.study.ex15readdbcrud.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {
    final private ReplyRepository replyRepository;

    //중간에 예외(오류)발생시 rollup을 수행하여, 데이터 일관성을 유지해줌.
    @Transactional
    public Long save(final ReplySaveRequestDto dto){
        Reply entity = replyRepository.save( dto.toEntity() );
        return entity.getReplyIdx();
    }
    @Transactional(readOnly = true)
    public boolean existsById( Long replyIdx ){
        boolean isFound = replyRepository.existsById(replyIdx);
        return isFound;
    }

}