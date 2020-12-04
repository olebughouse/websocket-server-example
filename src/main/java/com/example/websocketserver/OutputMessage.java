package com.example.websocketserver;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutputMessage {

    private String sender;

    private String message;

    private String time;
}
