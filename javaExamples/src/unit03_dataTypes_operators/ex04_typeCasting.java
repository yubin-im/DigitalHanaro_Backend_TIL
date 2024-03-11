package unit03_dataTypes_operators;

public class ex04_typeCasting {
    public static void main(String[] args) {
        // 형 변환 Type casting
        // 자동 형변환
        // 1. 같은 타입끼리 연산 될때
        int i = 10;
        int j = 20;
        int k = i * j;

        // 2. 다른 타입끼리 연산될 때 더큰 타입으로 변환
        long m = 10 * 20L;

        // 3. 작은 타입에서 큰 타입으로 대입될 때 큰 타입으로 변경
        long a = 10;

        // 4. 큰 타입에서 작은 타입으로 대입될떄
//        int b = 20L; // 자동 형변환 불가, 수동 형변환 해야됨

        // 수동 형변환
        // 형변환 연산자 사용
        // 주의할 점: 표현 범위를 벗어나면 값 잘림 (쓰레기 값)
        // 작은 타입 = (작은타입)큰 타입;
        int c = (int) 20L;
    }
}
