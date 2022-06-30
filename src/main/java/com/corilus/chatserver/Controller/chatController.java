package com.corilus.chatserver.Controller;

import com.corilus.chatserver.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class chatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("chatroom/public")
    private Message receivepublicMessage (@Payload Message message){
        return message;
    }

    @MessageMapping("/privateMessage")
    private Message receiveprivateMessage (@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private", message);
        return message;
    }
}
