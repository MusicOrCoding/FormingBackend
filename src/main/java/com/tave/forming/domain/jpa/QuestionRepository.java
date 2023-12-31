package com.tave.forming.domain.jpa;

import com.tave.forming.domain.survey.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//설문조사의 문항(질문)내용 저장
public interface QuestionRepository extends JpaRepository<Question,Long> {

/**
 * save 로직은 service : 비지니스 단에서 구현
 *
    public void addQ(Question question){
        em.persist(question);
 if (question.getId() == null) {
            em.persist(question);
        }
       else {
            em.merge(question);  }
    }

    public Question findOne(Long id) {
        return em.find(Question.class, id);
    }
**/


List<Question> findQuestionsBySurvey(Long id);
List<Question> findAll();
Optional<Question> findById(Long id);

}
