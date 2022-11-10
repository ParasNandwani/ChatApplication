package com.controller;


import com.common.CreateMessageRequest;
import com.common.CreateMessageResponse;
import com.common.DeleteMessageRespose;
import com.common.base.GetAllMessageResponse;
import com.common.base.ServiceResponse;
import com.entity.ChatMessage;
import com.exception.UserNotFoundException;
import com.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class ChatApplicationController {

    @Autowired
    private IChatService chatService;


    @PostMapping(path = "/chatlogs/{user}")
    public ResponseEntity<ServiceResponse> createMessage(@PathVariable("user") String userId, @RequestBody CreateMessageRequest createMessageRequest) throws UserNotFoundException {
        ChatMessage message = chatService.saveMessage(createMessageRequest, userId);
        CreateMessageResponse createMessageResponse = new CreateMessageResponse();
        createMessageResponse.setMessageID(message.getMessageId());
        createMessageResponse.setMessage("SUCCESS");
        createMessageResponse.setCode("101");
        return new ResponseEntity<ServiceResponse>(createMessageResponse,HttpStatus.CREATED);
    }


    @GetMapping(path = "/chatlogs/{user}")
    public ResponseEntity<GetAllMessageResponse> getChatMessages(@PathVariable("user") String userId,@RequestParam int pageSize) throws UserNotFoundException {
        GetAllMessageResponse allMessageRespose = chatService.getAllMessage(userId,pageSize);
        return  new ResponseEntity(allMessageRespose,HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(path = "/chatlogs/{user}")
    public ResponseEntity<String> deleteAllMessages(@PathVariable("user") String userId) {
        try {
            chatService.deleteAllMessages(userId);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("failed",HttpStatus.OK);

    }

    @ResponseBody
    @DeleteMapping(path = "/chatlogs/{user}/{msgid}")
    public ResponseEntity<DeleteMessageRespose> deleteMessage(@PathVariable("user") String userId, @PathVariable("msgid") String msgid) {
        try {
            chatService.deleteMessageByMessageId(msgid);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DeleteMessageRespose reesponse = new DeleteMessageRespose();
        return new ResponseEntity<>(reesponse,HttpStatus.OK);
    }

}
