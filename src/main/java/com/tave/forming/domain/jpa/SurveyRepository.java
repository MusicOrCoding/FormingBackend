package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Optional<Survey> findById(Long id);
    List<Survey> findAll();
    List<Survey> findByTitle(String title);
    List<Survey> findByUserId(Long id);
    List<Survey> findAllByDesc();


}
