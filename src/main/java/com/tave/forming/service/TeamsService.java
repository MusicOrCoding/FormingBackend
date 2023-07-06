package com.tave.forming.service;

import com.tave.forming.domain.jpa.TeamsRepository;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.dto.TeamsResponseDto;
import com.tave.forming.dto.TeamsSaveRequestDto;
import com.tave.forming.dto.TeamsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeamsService {
    private final TeamsRepository teamsRepository;

    @Transactional
    public Long save(TeamsSaveRequestDto requestDto){
        return teamsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, TeamsUpdateRequestDto requestDto) {
        Teams teams = teamsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 팀이 존재하지 않습니다. id = " + id));
        teams.update(requestDto.getName(), requestDto.getPassword(), requestDto.getGroup_type(), requestDto.getPoint());

        return id;
    }

    public TeamsResponseDto findById(Long id) {
        Teams entity = teamsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 팀이 존재하지 않습니다. id = " + id));
        return new TeamsResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        Teams teams = teamsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 팀이 존재하지 않습니다. id = " + id));

        teamsRepository.delete(teams);
    }
}
