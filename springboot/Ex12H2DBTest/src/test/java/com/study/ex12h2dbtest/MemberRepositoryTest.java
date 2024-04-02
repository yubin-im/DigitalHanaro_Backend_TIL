package com.study.ex12h2dbtest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.fail;

public class MemberRepositoryTest extends Ex12H2DbTestApplicationTests{
    // 필드 주입 (테스트 클래스는 생성자 주입안됨)
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll  // static 메소드
    static void setup() {
        System.out.println("@BeforeAll - 클래스를 초기화시 한번 수행");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - @Test 메소드를 호출시마다 한번 수행");
        save();
    }

    @Test  // 테스트할 메소드에 사용
    @DisplayName("save 테스트")  // 콘솔에 출력되는 메소드 이름
    public void save() {
        memberRepository.save(new MemberEntity(Long.valueOf(1), "hong", "1234", "홍길동", "ROLE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(Long.valueOf(2), "tom", "1234", "톰아저씨", "ROLE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(Long.valueOf(3), "admin", "1234", "관리자", "ROLE_ADMIN", LocalDate.now()));

        List<MemberEntity> list = memberRepository.findAll();

        for (MemberEntity m: list) {
            System.out.println(m.getUserName());
        }

        // 단정 함수(Assert Function)
//        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("findById 테스트")
    public void findById(){
        //Optional 클래스 : JDK 9부터 제공. null safety를 제공한다.
        Optional<MemberEntity> member = memberRepository.findById( 1L );
        member.ifPresent( unwrappedMemberEntity -> {
            //null이 아닐때 수행되는 람다식
            System.out.println( unwrappedMemberEntity.getUserName() );
            assertEquals( "홍길동", unwrappedMemberEntity.getUserName() );
        });
        if( member.isPresent() ) {
            String name = member.get().getUserName();
            assertEquals( "홍길동", name );
        }else{
            fail("member 값 가져오기 실패");
        }

    }

    @Test
    @DisplayName("count 테스트")
    public void count() {
        // SQL: SELECT COUNT(*) FROM member;
        Long count = memberRepository.count();
        System.out.println("count: " + count);
        assertEquals(3, count, "count 테스트 실패!");
    }

    @Test
    @DisplayName("쿼리메소드 테스트")
    public void query() {
        // 패턴: find + By + 필드이름 + And + 필드이름
        List<MemberEntity> list = memberRepository.findByUserId("tom");
        assertEquals(1, list.size());
        assertEquals("톰아저씨", list.get(0).getUserName());

        List<MemberEntity> list2 = memberRepository.findFirst5ByUserIdAndUserNameOrderByIdDesc("hong", "홍길동");
        assertEquals(1, list2.size());

        Boolean isExist = memberRepository.existsByJoindateLessThanEqual(LocalDate.now());
        System.out.println("isExist" + isExist);

        long count = memberRepository.countByUserNameIgnoreCaseLike("길");
        System.out.println("count: " + count);
    }

    @Test
    @DisplayName("JPQL 테스트")
    public void jpqlQuery() {
        List<MemberEntity> list = memberRepository.findByUserId_JPQL_Query("tom");
        assertEquals(1, list.size());
        assertEquals("톰아저씨", list.get(0).getUserName());
    }

    @Test
    @DisplayName("Native Query 테스트")
    public void nativeQuery(){
        List<MemberEntity> list =
                memberRepository.findByUserId_nativeQuery("admin");
        assertEquals(1, list.size());
        assertEquals("관리자", list.get(0).getUserName());
    }


}
