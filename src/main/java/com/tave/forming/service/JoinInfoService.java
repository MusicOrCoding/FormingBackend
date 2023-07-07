package com.tave.forming.service;

import com.tave.forming.domain.jpa.JoinInfoRepository;
import com.tave.forming.domain.jpa.TeamsRepository;
import com.tave.forming.dto.JoinSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class JoinInfoService {

    public final JoinInfoRepository joinInfoRepository;
    public final TeamsRepository teamsRepository;

    @Transactional
    public Long saveJoinInfo(JoinSaveRequestDto requestDto) {
        return joinInfoRepository.save(requestDto.toEntity()).getId();
    }

//    public List<Teams> findJoinTeams() {
//
//    }


}
