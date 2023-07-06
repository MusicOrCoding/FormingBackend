package com.tave.forming.controller;

import com.tave.forming.dto.SurveySaveRequestDto;
import com.tave.forming.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SurveyController {

    private final SurveyService surveyService;

    /**
     * @PostMapping("/survey/new") public Long save(Model model) {
     * Model.addAttribute("")
     * return surveyService.save();
     * }
     **/
    @PostMapping("/survey/new")
    public Long saveSurvey(@RequestBody SurveySaveRequestDto dto) {
        return surveyService.saveSurvey(dto);
    }
}
//    @PostMapping("/survey/new")
//    public CreateSurveyResponse saveSurvey(@RequestBody @Valid CreateSurveyRequest request) {
//
//        List<Question> q = new ArrayList<>();
//        for(Question question : request.questions) {
//            q.add(question);
//        }
//        Survey survey = Survey.createSurvey(request.getTitle(), request.getContent(), request.getIs_team(), request.getDeadline_date(), request.getMax_participants(), request.getIs_over(), request.getReward_point(), request.getCost_point(), request.getTarget(), request.getUser(),  request.getTeam_id(), request.getQuestions() );
//        Long id = surveyService.saveSurvey(survey);
//        return new CreateSurveyResponse(id);
//    }

//    @Data
//    static class CreateSurveyRequest {
//        private String title;
//        private String content;
//        private int is_team;
//        private LocalDateTime deadline_date;
//        private Long max_participants;
//        private int is_over;
//        private Long reward_point;
//        private Long cost_point;
//        private String target;
//        private User user;
//        private Long team_id;
//        private List<Question> questions;
//    }
//
//    @Data
//    static class CreateSurveyResponse {
//        private Long id;
//
//        public CreateSurveyResponse(Long id) {
//            this.id = id;
//        }
//    }



//    @GetMapping("/")
//    public Result findSurveys() {
//        List<Survey> findSurveys = surveyService.findSurveys();
//        List<SurveyDto> collect = findSurveys.stream()
//                .map(m -> new SurveyDto(m.getTitle(), m.getContent(), m.getIs_team(), m.getDeadline_date(), m.getMax_participants(), m.getIs_over(), m.getReward_point(), m.getCost_point(), m.getTarget(), m.getUser(), m.getTeam_id(), m.getQuestions()))
//                .collect(Collectors.toList());
//
//        return new Result(collect);
//    }
//
//    @Data
//    @AllArgsConstructor
//    static class Result<T> {
//        private T data;
//    }
//
//    @Data
//    @AllArgsConstructor
//    static class SurveyDto {
//
//        private String title;
//        private String content;
//        private int is_team;
//        private LocalDateTime deadline_date;
//        private Long max_participants;
//        private int is_over;
//        private Long reward_point;
//        private Long cost_point;
//        private String target;
//        private User user;
//        private Long team_id;
//        private List<Question> questions;
//    }
//}
