package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
