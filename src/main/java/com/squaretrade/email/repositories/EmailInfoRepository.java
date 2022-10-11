package com.squaretrade.email.repositories;

import com.squaretrade.email.entities.EmailInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailInfoRepository extends JpaRepository<EmailInfo, String> {

}
