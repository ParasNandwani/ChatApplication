package com.service;

import com.common.CreateMessageRequest;
import com.common.base.GetAllMessageResponse;
import com.entity.ChatMessage;
import com.exception.UserNotFoundException;
import com.repository.ChatMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ChatServiceImpl implements  IChatService{
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired(required = true)
    ChatMessageRepository chatRepo;

    @Override
    @Transactional
    public ChatMessage saveMessage(CreateMessageRequest createMessageRequest, String userId) throws UserNotFoundException {
        if(userId == null ) throw new UserNotFoundException();
        ChatMessage message = new ChatMessage();
        message.setMessage(createMessageRequest.getTextMessage());
        message.setTimeStamp(createMessageRequest.getTimestamp());
        message.setUserId(userId);
        return chatRepo.save(message);
    }



    @Override
    public GetAllMessageResponse getAllMessage(String userId ,int size) throws UserNotFoundException {
        if(userId == null) return null;
        Pageable sortedByMessageId =  PageRequest.of(0, size, Sort.by(Sort.Direction.DESC,"messageId"));
        List<ChatMessage> chatMessages =  chatRepo.findByUserId(userId,sortedByMessageId);
        GetAllMessageResponse messageResponse = new GetAllMessageResponse();
        messageResponse.setChatMessages(chatMessages);
        return  messageResponse;
    }

    @Override
    @Transactional
    public void deleteAllMessages(String userId) {
        chatRepo.deleteAllByUserId(userId);
    }

    @Override
    public void deleteMessageByMessageId(String msgId) {
         chatRepo.deleteByMessageId(msgId);
    }
}
