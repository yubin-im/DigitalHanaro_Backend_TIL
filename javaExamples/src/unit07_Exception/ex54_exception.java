package unit07_Exception;

public class ex54_exception {
    public static void main(String[] args) {
        // 예외처리 (Exception Handling)
        // 예상하지 못한 오류- 개발/실행 단계에서 처리 가능하다.
        // 1, try - catch (finally)
        // 2. throws

        String name = null;
        System.out.println(name);

        // java.lang.NullPointerException
//        System.out.println(name.toLowerCase());

        try {
            System.out.println(name.toLowerCase());
        } catch (Exception e) {
            // 예외 내용 출력
            System.out.println(e.getMessage());
            // 예외 경로 출력
            e.printStackTrace();
        }

        System.out.println("예외 후 코드");
    }
}
