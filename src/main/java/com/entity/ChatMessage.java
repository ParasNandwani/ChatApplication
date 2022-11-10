package com.entity;

import javax.persistence.*;

@Entity
@Table(name =  "chat_message")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long messageId;

    @Column(name = "created")
    private long timeStamp ;

    @Column(name = "message")
    private String message;

    @Column(name = "user_id")
    private String userId;

    public long getMessageId() { return messageId; }

    public void setMessageId(long messageId) { this.messageId = messageId;}

    public long getTimeStamp() { return timeStamp; }

    public void setTimeStamp(long timeStamp) { this.timeStamp = timeStamp;}

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }
}
