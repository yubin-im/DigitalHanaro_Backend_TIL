package com.study.ex12h2db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository: 스프링 JPA 라이브러리에서 Entity에 대한 기본적인 CRUD 가능하도록 만든 인터페이스
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
