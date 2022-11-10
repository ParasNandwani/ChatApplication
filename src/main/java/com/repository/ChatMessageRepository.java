package com.repository;

import com.entity.ChatMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository  extends PagingAndSortingRepository<ChatMessage,String> {
    List<ChatMessage> findByUserId(String userId, Pageable pageable);
    void deleteByMessageId(String messageId);
    void deleteAllByUserId(String userId);
}
