package unit03_dataTypes_operators;

public class ex11_logicalOperator {
    public static void main(String[] args) {
        // 논리 연산자
        // AND &&: ~이고, ~이면서
        // OR ||: ~이거나, 또는, ~중에 하나
        // NOT !: ~아니다

        // T && T: T  둘 다 참이면 참
        // T && F: F
        // F && T: F
        // F && F: F

        // T || T: T
        // T || F: T
        // F || T: T
        // F || F: F  둘 다 거짓이면 거짓

        // !T: F
        // !F: T


        // XOR ^: 비트 단위 연산자
        // 1 ^ 1 = 0
        // 1 ^ 0 = 1  // 서로 값이 다르면 1
        // 0 ^ 1 = 1
        // 0 ^ 0 = 0
    }
}
