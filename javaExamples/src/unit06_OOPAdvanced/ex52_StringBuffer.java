package unit06_OOPAdvanced;

public class ex52_StringBuffer {
    public static void main(String[] args) {
        // String 관련 클래스
        // StringBuffer: 문자열을 좀더 유연하게 제어 가능
        // 추가(append), 삽입(insert), 삭제(delete)
        // StringBuilder: 대량의 문자열을 처리할 때 속도 향상
        // 추가(append), 삽입(insert), 삭제(delete)
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb);

        sb.append("def");
        System.out.println(sb);

        sb.insert(3, "123");
        System.out.println(sb);

        sb.delete(2, 4); // 시작, 끝 인덱스
        System.out.println(sb);

        StringBuilder builder = new StringBuilder(sb);
        // append, insert, delete 동일하게 사용 가능
    }
}
