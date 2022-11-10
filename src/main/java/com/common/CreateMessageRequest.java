package com.common;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMessageRequest {
    private String textMessage;
    private long timestamp;
    private boolean isSent;
}
