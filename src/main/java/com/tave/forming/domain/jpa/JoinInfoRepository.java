package com.tave.forming.domain.jpa;

import com.tave.forming.domain.joinInfo.JoinInfo;
import com.tave.forming.domain.teams.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JoinInfoRepository extends JpaRepository<JoinInfo, Long> {

    @Query("SELECT DISTINCT t FROM Teams WHERE t.id IN (SELECT team_id FROM Join_info j WHERE j.user_id = :id)")
    List<Teams> findByJoinedUserId(@Param("id") Long id);
}
