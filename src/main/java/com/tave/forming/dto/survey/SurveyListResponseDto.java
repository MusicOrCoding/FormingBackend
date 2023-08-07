//package com.tave.forming.dto;
//
//import com.tave.forming.domain.survey.Question;
//import com.tave.forming.domain.survey.Survey;
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//public class SurveyListResponseDto {
//    private Long id;
//
//    private List<Question> questions = new ArrayList<>();
//
//    private String title;
//
//    private String content;
//
//    private int is_team;
//
//    private Long question_count;
//
//    private LocalDateTime deadline_date;
//
//    private Long max_participants;
//
//    private int is_over;
//
//    private Long reward_point;
//
//    private Long cost_point;
//
//    private String target;
//
//    private Long user_id;
//
//    private Long team_id;
//
//    private LocalDateTime modifiedDate;
//
//    public SurveyListResponseDto(Survey entity){
//        this.id = entity.getId();
//        this.questions = entity.getQuestions();
//        this.title = entity.getTitle();
//        this.content = entity.getContent();
//        this.is_team = entity.getIs_team();
//        this.question_count = entity.getQuestion_count();
//        this.deadline_date = entity.getDeadline_date();
//        this.max_participants = entity.getMax_participants();
//        this.is_over = entity.getIs_over();
//        this.reward_point = entity.getReward_point();
//        this.cost_point = entity.getCost_point();
//        this.target = entity.getTarget();
//        this.user_id = entity.getUser_id();
//        this.team_id = entity.getTeam_id();
//        this.modifiedDate = entity.getModifiedDate();
//    }
//}
