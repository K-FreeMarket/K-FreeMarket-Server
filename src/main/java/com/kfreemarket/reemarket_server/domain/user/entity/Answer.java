package com.kfreemarket.reemarket_server.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Answer {

    @Id
    @Column(name = "question_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId  // 핵심! 이걸 통해 question_id를 PK로도 사용
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    @Builder
    public Answer(Question question, String content) {
        this.question = question;
        this.content = content;
    }
}
