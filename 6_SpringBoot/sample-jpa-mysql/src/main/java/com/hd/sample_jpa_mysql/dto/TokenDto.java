package com.hd.sample_jpa_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String grantType; // 인증 방식
    private String accessToken;
    private String refreshToken;
    private Long tokenExpiresIn;
    private Long refreshExpireIn;

}
