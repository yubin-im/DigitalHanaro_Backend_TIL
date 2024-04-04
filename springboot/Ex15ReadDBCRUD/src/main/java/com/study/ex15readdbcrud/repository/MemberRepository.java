package com.study.ex15readdbcrud.repository;

import com.study.ex15readdbcrud.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 기본 메소드
    // 1. findAll: SELECT *
    // 2. findById: SELECT * WHERE id = :id
    // 3. count(): SELECT COUNT(*)
    // 4. save(): UPDATE, INSERT
    // 5. delete() : DELETE

    // 쿼리 메소드, JPQL, NativeSQL 아래에 등록한다.
}
