package com.tave.forming.domain.jpa;

import com.tave.forming.domain.teams.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//Teams 클래스로 db에 접근해줄 수 있도록 함
public interface TeamsRepository extends JpaRepository<Teams, Long> {


    Optional<Teams> findById(Long teamId);
    @Query("SELECT DISTINCT t FROM Teams WHERE t.id IN (SELECT team_id FROM Join_info j WHERE j.user_id = :id)")
    List<Teams> findByJoinedUserId(@Param("id") Long id);
    Optional<Teams> findByName(String name);
}
