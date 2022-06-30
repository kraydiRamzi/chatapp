package com.corilus.chatserver.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;



}
