package unit03_dataTypes_operators;

public class ex10_arithmeticOperator2 {
    public static void main(String[] args) {
        // 비트단위 이동 연산자: <<, >>, >>>
        // 최상위 비트가 0이면 양수, 1이면 음수이다.

        // 컴퓨터가 음수를 만드는 방법
        // 2의 보수: 1의 보수 + 1
        // 1의 보수: 0-> 1, 1-> 0
        // +1을 -1로 만드는 과정
        // 0000...0001 -> 1111...1110 -> 1111...1111

        // <<: 왼쪽으로 비트 이동 *2의 효과
        // LSB(비트의 가장오른쪽)는 0이 들어온다.
        // MSB(비트의 가장앞)는 0이면 0, 1이면 1로 지켜진다.
        int i = 1;  // 0000...0001
        System.out.println(i << 1);  // 0000...0010
        System.out.println(i << 2);  // 0000...0100
        System.out.println(-1 << 1);  // 1111...1110

        // >>: 오른쪽으로 비트 이동 /2의 효과
        // 양수이면 MSB(비트의 가장앞)는 0이, 음수이면 1이 들어온다.
        System.out.println(1 >> 1);  // 0000...0000
        System.out.println(-1 >> 1);  // 1111...1111

        // >>>: 오른쪽으로 비트이동하되 논리적 이동
        // 양수든 음수든 0이 들어온다.
        System.out.println(1 >>> 1);  // 0000...0000
        System.out.println(-1 >>> 1);  // 0111...1111
    }
}
