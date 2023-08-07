package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Optional<Survey> findById(Long id);
    List<Survey> findAll();
    List<Survey> findByTitle(String title);
    List<Survey> findByUserId(Long id);
    List<Survey> findAllByDesc();

    @Query("DELETE FROM Survey s where s.id=:surveyId")
    void deleteSurveyById(Long surveyId);



}
