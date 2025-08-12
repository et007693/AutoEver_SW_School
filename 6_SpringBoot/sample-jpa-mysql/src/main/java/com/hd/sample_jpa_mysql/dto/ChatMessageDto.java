package com.hd.sample_jpa_mysql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ChatMessageDto {
    public enum MessageType {
        ENTER, TALK, CLOSE
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
