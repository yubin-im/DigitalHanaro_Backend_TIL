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
import static org.junit.jupiter.api.Assertions.fail;

// 연습문제
// 아래와 같이 H2DB를 초기화 하고, 아래 결과를 출력하시오.
// 쿼리 메소드 또는 Native SQL, JPQL 방법 중 하나를 사용하시오.
// 1. member 테이블 안에 암호가 "1234"인 회원이 있는지 테스트 하시오.
// 2. 23년도 3월에 가입한 회원의 수가 1인지 테스트하시오.
// 3. "lee"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.
// 4. "tom"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.
//    톰아저씨 -> 마이클, 암호 -> 3456

public class exerciseTest extends Ex12H2DbTestApplicationTests{
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - 클래스를 초기화시 한번 수행");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - @Test 메소드를 호출시마다 한번 수행");
        save();
    }

    @Test
    @DisplayName("save 테스트")
    public void save() {
        memberRepository.save(new MemberEntity(Long.valueOf(1), "hong", "1234", "홍길동", "ROLE_USER", LocalDate.parse("2023-01-01")));
        memberRepository.save(new MemberEntity(Long.valueOf(2), "tom", "1234", "톰아저씨", "ROLE_USER", LocalDate.parse("2023-02-01")));
        memberRepository.save(new MemberEntity(Long.valueOf(3), "admin", "1234", "관리자", "ROLE_ADMIN", LocalDate.parse("2023-03-01")));

        List<MemberEntity> list = memberRepository.findAll();

        for (MemberEntity m: list) {
            System.out.println(m.getUserName());
        }
    }

    // 1. member 테이블 안에 암호가 "1234"인 회원이 있는지 테스트 하시오.
    @Test
    @DisplayName("1. 암호가 1234 회원")
    public void pw1234() {
        List<MemberEntity> list = memberRepository.findByUserPwIsLike("1234");

//        System.out.print("member 테이블 안에 암호가 \"1234\"인 회원: ");
//        for (MemberEntity m: list) {
//            System.out.print(m.getUserName() + " ");
//        }
//        System.out.println();

        assertEquals(0, list.size(), "암호가 1234인 회원이 존재합니다.");
    }

    // 2. 23년도 3월에 가입한 회원의 수가 1인지 테스트하시오.
    @Test
    @DisplayName("2. 23년도 3월에 가입한 회원")
    public void month3() {
        List<MemberEntity> list = memberRepository.findByJoindate_DayOfMonth(3);

//        System.out.print("23년도 3월에 가입한 회원: ");
//        for (MemberEntity m: list) {
//            System.out.print(m.getUserName() + " ");
//        }
//        System.out.println();

        assertEquals(1, list.size());
    }

    // 3. "lee"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.
    @Test
    @DisplayName("3. lee 아이디 회원 확인")
    public void userIdLee() {
        List<MemberEntity> list = memberRepository.findByUserIdEquals("lee");
        assertEquals(0, list.size(), "해당 아이디가 존재합니다.");
    }

    // 4. "tom"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.
    //    톰아저씨 -> 마이클, 암호 -> 3456
    @Test
    @DisplayName("4. update tom")
    public void updateTom() {
        int result = memberRepository.updateByUserId_nativeQuery("tom", "마이클", "3456");
        assertEquals(1, result);

        Optional<MemberEntity> member =
                memberRepository.findById(2L);
        System.out.println(member.get().getUserName() + ", " + member.get().getUserPw());
    }
}
