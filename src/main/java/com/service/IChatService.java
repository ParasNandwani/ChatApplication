package com.service;

import com.common.CreateMessageRequest;
import com.common.base.GetAllMessageResponse;
import com.entity.ChatMessage;
import com.exception.UserNotFoundException;

public interface IChatService {
    ChatMessage saveMessage(CreateMessageRequest createMessageRequest, String userId) throws UserNotFoundException;
    GetAllMessageResponse getAllMessage(String userId,int size) throws UserNotFoundException;
    void deleteAllMessages(String userId);
    void deleteMessageByMessageId(String msgId);
}
