package com.common.base;

import com.entity.ChatMessage;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public  class GetAllMessageResponse extends ServiceResponse{
   private  List<ChatMessage> chatMessages;
}
