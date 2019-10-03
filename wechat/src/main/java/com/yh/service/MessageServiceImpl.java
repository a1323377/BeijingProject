package com.yh.service;

import com.yh.domain.Message;
import com.yh.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Resource(name = "messageMapper")
    MessageMapper messageMapper;
    @Override
    public List<Message> selectAllMessageByGroupSort() {
        return messageMapper.selectAllMessageByGroupSort();
    }
}
