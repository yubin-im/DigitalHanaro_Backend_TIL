public class ex12_ternaryOperator {
    public static void main(String[] args) {
        // 삼항 연산자: ? : 물음표 연산자
        // 패턴: (조건절) ? 참일때 값 : 거짓일때 값
        int i = 10 < 20 ? 10 : 20;
        System.out.println(i);

        // 삼항 연산자는 중복해서 쓰지 않도록 권장함
        int j = (10 < 20) ? ((20 < 30) ? 20 : 30) : 40;
        System.out.println(j);
    }
}
