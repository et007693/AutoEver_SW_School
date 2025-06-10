package com.hd.sample_jpa_mysql.repository;

import com.hd.sample_jpa_mysql.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
