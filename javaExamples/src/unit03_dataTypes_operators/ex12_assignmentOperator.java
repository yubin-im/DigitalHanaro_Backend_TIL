package unit03_dataTypes_operators;

public class ex12_assignmentOperator {
    public static void main(String[] args) {
        // 대입 연산자
        // A = B: B 값을 A에 덮어쓰기
        // 값의 전달 방향이 오른쪽에서 왼쪽
        // 단항 연산자이므로 연산이므로 연산 순서도 오른쪽에서 왼쪽으로
        int i = 10;
        int j = 20;
        int k = 30;

        i = j = k = 40;
        System.out.println(i);  // 가장 왼쪽에 있는 i에 40 대입

        // 복합 대입 연산자
        // A += B: A = A + B
        // A -= B: A = A - B
        // A *= B: A = A * B
        // A /= B: A = A / B
    }
}
