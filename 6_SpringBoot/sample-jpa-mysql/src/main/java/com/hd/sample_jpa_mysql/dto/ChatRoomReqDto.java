package com.hd.sample_jpa_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomReqDto { // 채팅방 개설 요청
    private String name; // 방 제목

}
