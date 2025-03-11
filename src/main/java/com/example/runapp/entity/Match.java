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
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;

    @Column(nullable = false)
    private Integer userId1;

    @Column(nullable = false)
    private Integer userId2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime matchedAt;

    public enum Status {
        PENDING, ACCEPTED, REJECTED
    }
}
