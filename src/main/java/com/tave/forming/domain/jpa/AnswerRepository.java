package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

//사용자의 설문조사 응답 저장
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
