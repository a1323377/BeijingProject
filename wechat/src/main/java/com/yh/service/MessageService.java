package com.yh.service;

import com.yh.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> selectAllMessageByGroupSort();
}
