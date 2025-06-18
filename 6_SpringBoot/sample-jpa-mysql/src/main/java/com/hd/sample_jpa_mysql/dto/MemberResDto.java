package com.hd.sample_jpa_mysql.dto;

import com.hd.sample_jpa_mysql.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResDto {
    private String email;
    private String name;
    private String pwd;
    private String image;
    private LocalDateTime regDate;

    public static MemberResDto of(Member member) {
        return MemberResDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .image(member.getImage())
                .regDate(member.getRegData())
                .build();
    }
}
