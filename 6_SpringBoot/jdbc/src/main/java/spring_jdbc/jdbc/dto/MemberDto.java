package spring_jdbc.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MemberDto {
    private String email;
    private String password;
    private String name;
    private LocalDateTime date;
}