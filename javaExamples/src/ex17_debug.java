public class ex17_debug {
    public static void main(String[] args) {
        // 런타임 디버깅 사용법
        // 반복문에서 코드의 흐름을 파악하거나 변수의 값을 확인하는 용도로 사용
        // print문 만으로 전체 맥락을 파악하기 어려울 때 사용

        // 실행 > Debug (Shift + F9) 기능 이용
        // Break Point(중단점)을 설정한다. (CTRL + F8)
        // Step Over(F8): 다음줄로 이동
        // Step Into(F7): 함수 안으로 이동
        // 다시시작(F9): 계속해서 진행(Resume)
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        myFunc();
    }

    static void myFunc() {
        System.out.println("myFunc!");
    }
}
