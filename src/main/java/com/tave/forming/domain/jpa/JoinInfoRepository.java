package com.tave.forming.domain.jpa;

import com.tave.forming.domain.joinInfo.JoinInfo;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//사용자별 팀 가입 정보 저장
public interface JoinInfoRepository extends JpaRepository<JoinInfo, Long> {

    Long findByUser(User user);
    Optional<JoinInfo> findByUserAndTeam(User user, Teams team);

}
