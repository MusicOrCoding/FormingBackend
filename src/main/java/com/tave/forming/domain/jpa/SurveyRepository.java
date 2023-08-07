package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.teams.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//설문조사 내용 저장
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Optional<Survey> findById(Long id);
    List<Survey> findAll();
    List<Survey> findByTitle(String title);
    List<Survey> findByUserId(Long id);
    List<Survey> findAllByDesc();
    List<Survey> findByTeam(Teams team);


}
