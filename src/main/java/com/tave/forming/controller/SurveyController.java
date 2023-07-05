package com.tave.forming.controller;

import com.tave.forming.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("surveys", surveyService.findSurveys());
        return "index";
    }
}
