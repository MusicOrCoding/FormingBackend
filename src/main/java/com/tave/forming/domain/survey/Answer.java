package com.tave.forming.domain.survey;

import com.tave.forming.domain.BaseTimeEntity;
import com.tave.forming.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//사용자의 설문조사 답변 엔티티
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Answer extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_option_id")
    private AnswerOption answerOption;

    private String content;



    @Builder
    public Answer(User user, AnswerOption answerOption, String content) {
        this.user = user;
        this.answerOption = answerOption;
        this.content = content;
    }
}
