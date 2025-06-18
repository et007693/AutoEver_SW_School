package com.hd.sample_jpa_mysql.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    private SecurityUtil() {}

    public static Long getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getName() == null) throw new RuntimeException("Security Context에 인증 정보가 업습니다.");
        return Long.parseLong(authentication.getName());
    }
}
