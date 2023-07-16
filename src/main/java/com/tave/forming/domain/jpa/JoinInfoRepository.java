package com.tave.forming.domain.jpa;

import com.tave.forming.domain.joinInfo.JoinInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinInfoRepository extends JpaRepository<JoinInfo, Long> {

    Long findByUserId(Long user_id);

}
