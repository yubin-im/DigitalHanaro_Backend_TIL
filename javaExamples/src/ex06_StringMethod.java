import java.util.Arrays;

public class ex06_StringMethod {
    public static void main(String[] args) {
        // 문자열 관련 함수들
        String str1 = "Hello Java!";
        String str2 = "안녕하세요! 반갑습니다.";

        // 문자열 길이
        System.out.println(str1.length());
        System.out.println(str2.length());

        // 문자 한자만 가져오기
        char c1 = str1.charAt(0);  // 인덱스 값 주기
        System.out.println(c1);

        // 문자열 위치(인덱스) 가져오기
        System.out.println(str1.indexOf("Java"));
        System.out.println(str1.lastIndexOf("a"));  // 끝에서 부터 검색

        // 대, 소문자로 바꾸기
        String str3 = "Java Study!";
        System.out.println(str3.toUpperCase());  // 대문자
        System.out.println(str3.toLowerCase());  // 소문자
        // 문자열 검색 시 다 소문자로 바꿔서 검색하기
        System.out.println(str3.toLowerCase().indexOf("java"));

        // 문자열 치환하기
        System.out.println(str3.replace("Study", "공부"));

        // 문자열 일부 가져오기
        System.out.println(str3.substring(0, 5));

        // 문자열을 분리해서 문자열 배열로 가져오기
        String[] strArray = "abc/def-ghi jkl".split("/|-| ");
        // Arrays.toString(): 배열을 문자열로 변환해주는 함수
        System.out.println(strArray);
        System.out.println(Arrays.toString(strArray));

        // 문자열의 처음과 끝의 공백만 제거 (가운데 공백은 미제거)
        System.out.println(" abc ".trim());
        // 모든 공백 제거
        System.out.println(" abc def ".replaceAll(" ", ""));

        // 문자열 연결 함수
        System.out.println("abc".concat("123"));

        // 문자열을 포함하는지 true/false로 반환하는 함수
        System.out.println("abc123".contains("123"));

        // 문자열 내용 비교
        String str4 = "Java";
        String str5 = "java";
        // 주소값 정수 비교
        System.out.println(str4 == str5);
        // 내용 비교
        System.out.println(str4.equals(str5));
    }
}
