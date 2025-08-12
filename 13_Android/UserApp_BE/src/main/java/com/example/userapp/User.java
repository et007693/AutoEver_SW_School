package com.example.userapp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // 예약어 피하기
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}