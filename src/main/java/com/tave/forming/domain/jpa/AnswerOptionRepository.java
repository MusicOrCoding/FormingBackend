package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.Option;
import org.springframework.data.jpa.repository.JpaRepository;

//설문조사 문항별 답변 옵션 저장
public interface AnswerOptionRepository extends JpaRepository<Option, Long> {
}
