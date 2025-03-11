package com.example.runapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자 Lombok으로 생성
@AllArgsConstructor // 모든 필드를 포함하는 생성자 Lombok으로 생성
@Entity
@Access(AccessType.FIELD)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String username;

    private Integer age;
    private String gender;
}
