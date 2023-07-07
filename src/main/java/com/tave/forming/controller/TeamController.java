package com.tave.forming.controller;

import com.tave.forming.dto.JoinSaveRequestDto;
import com.tave.forming.dto.TeamsResponseDto;
import com.tave.forming.dto.TeamsSaveRequestDto;
import com.tave.forming.dto.TeamsUpdateRequestDto;
import com.tave.forming.service.JoinInfoService;
import com.tave.forming.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamsService teamsService;
    private final JoinInfoService joinInfoService;

    //팀 생성
    @PostMapping("/team/new")
    public Long save(@RequestBody TeamsSaveRequestDto requestDto) {
        return teamsService.save(requestDto);
    }

    //팀 수정
    @PutMapping("/team/{id}")
    public Long update(@PathVariable Long id, @RequestBody TeamsUpdateRequestDto requestDto) {
        return teamsService.update(id, requestDto);
    }

    //팀 조회
    @GetMapping("/team/{id}")
    public TeamsResponseDto findById (@PathVariable Long id) {
        return teamsService.findById(id);
    }

    //팀 삭제
    @DeleteMapping("/team/{id}")
    public Long delete(@PathVariable Long id) {
        teamsService.delete(id);
        return id;
    }

    //팀 가입
    @PostMapping("/team/join/{id}")
    public Long join(@RequestBody JoinSaveRequestDto requestDto) {
        return joinInfoService.saveJoinInfo(requestDto);
    }

    //회원이 가입한 모든 팀들 조회
    @GetMapping("/team/join/{user_id}")
    public String findJoinTeams(@PathVariable Long id, Model model) {
        model.addAttribute("joined teams", teamsService.findJoinedTeamByUserId(id));

        return "index";
    }

}
