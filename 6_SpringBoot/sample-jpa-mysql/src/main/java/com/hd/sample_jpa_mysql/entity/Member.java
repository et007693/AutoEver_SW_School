package com.hd.sample_jpa_mysql.entity;

import com.hd.sample_jpa_mysql.constant.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor // 매개변수 없는 생성자
public class Member {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.AUTO) // 생성조건
    @Column(name = "member_id") // column 명
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(nullable = false) // not null
    private String pwd;

    @Column(unique = true, length = 150) // unique
    private String email;

    @Column(length = 255)
    private String image;

    private LocalDateTime regData;

//    @PrePersist // DB에 insert 되기전에 실행되는 메소드
//    private void prePersist() {
//        this.regData = LocalDateTime.now();
//    }
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String name, String pwd, String email, String image, Authority authority) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.image = image;
        this.regData = LocalDateTime.now();
        this.authority = authority;
    }
}
