package com.tave.forming.domain.jpa;

import com.tave.forming.domain.teams.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

//Teams 클래스로 db에 접근해줄 수 있도록 함
public interface TeamsRepository extends JpaRepository<Teams, Long> {


}
