package com.example.runapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chatId;

    @Column(nullable = false)
    private Integer matchId;

    @Column(nullable = false)
    private Integer senderId;

    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime sentAt;
}
