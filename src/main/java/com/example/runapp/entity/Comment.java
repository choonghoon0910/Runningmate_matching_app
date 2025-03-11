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
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(nullable = false)
    private Integer postId;

    @Column(nullable = false)
    private Integer authorId;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;
}
