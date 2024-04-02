package com.study.ex12h2dbtest;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository : JPA DAO 클래스에 적용하고, @Component가 내부에 있음.
//@Service : 서비스 로직 클래스에 적용되고, @Component가 내부에 있음.
//@Controller : 컨트롤 인터페이스(HTTP 요청처리)를 구현하고,
//           @Component가 내부에 있음.

// JpaRepository: 스프링 JPA 라이브러리에서 Entity에 대한 기본적인 CRUD 가능하도록 만든 인터페이스
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //JpaRepository의 기본함수
    //1. findAll() : SQL(Select * from Table)문을 실행한다.
    //2. save() : SQL의 insert문과 update문을 실행한다. id값을 보고 없으면 추가,
    //           있으면 수정한다.
    //3. delete() : SQL delete문을 수행한다.

    //쿼리 메소드
    //findBy열이름() : SQL(Select 열이름 from Table)문을 실행한다.
    //  예) findById((long)2) : Select * from member where id=2;
    //  예) findByUser_id("hong") : Select * from member where user_id='hong';

    // SQL: select * from member where user_id = :userId;
    List<MemberEntity> findByUserId(String userId);

    // SQL: SELECT * FROM member where user_id = :userId AND user_name = :userName ORDER BY id DESC LIMIT 5;
    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(String userId, String userName);

    Boolean existsByJoindateLessThanEqual(LocalDate date);

    long countByUserNameIgnoreCaseLike(String userId);

    //JPA에서 SQL을 사용하는 방법
    //1. JPQL
    // - 표준 ANSI SQL 문법을 지원함.
    // - 특정 데이터베이스에 종속적인 기능은 지원하지 않음.
    // - from절 뒤에는 엔티티 클래스이름을 넣어준다.(소문자로 하면 에러)
    @Query(value="SELECT m FROM MemberEntity m WHERE m.userId = :userid")
    List<MemberEntity> findByUserId_JPQL_Query(String userid);

    //2. Native SQL
    // - 특정 데이터베이스에 종속적인 기능을 제공한다.
    //   예) MySQL : LIMIT 5, now(), AUTO_INCREMENT
    //      Oracle : sysdate, 시퀀스
    // Update,Insert,Delete문은 @Modifying, @Transactional을 추가해야 됨.
    @Query(value = "SELECT * FROM member WHERE user_id = :userid",
            nativeQuery = true)
    List<MemberEntity> findByUserId_nativeQuery(String userid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_id = :userid where id = :id",
            nativeQuery = true)
    int updateById_nativeQuery(Long id);
}