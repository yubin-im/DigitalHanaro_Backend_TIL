package DBMS;

import java.util.List;

public class MemberMain {
    public static void main(String[] args) {
        // DAO 객체 생성
        MemberDAO dao = new MemberDAO();

        // 레코드 추가
        MemberVO vo = new MemberVO();
        vo.setMemberno(5);
        vo.setId("min");
        vo.setName("김민재");

        int result = dao.insert(vo);
        if (result > 0) {
            System.out.println("회원 등록 성공!");
        } else {
            System.out.println("회원 등록 실패!");
        }

        // 전체 목록 조회
        List<MemberVO> list = dao.list();
        for (MemberVO member : list) {
            System.out.println("회원번호:" + member.getMemberno());
            System.out.println("아이디:" + member.getId());
            System.out.println("이름:" + member.getName());
        }

        // 단건 조회
        MemberVO member = dao.selectOne(3);
        System.out.println("회원번호:" + member.getMemberno());
        System.out.println("아이디:" + member.getId());
        System.out.println("이름:" + member.getName());

        // 삭제
        result = dao.delete(5);
        if (result > 0) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }

        // 자원 해제
        dao.close();
    }
}
