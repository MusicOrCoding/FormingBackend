package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
}
