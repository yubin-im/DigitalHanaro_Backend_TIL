public class ex08_unaryOperator {
    public static void main(String[] args) {
        // 단항 연산자: ++, --, !(논리반전), (타입), ~(비트반전)
        int i = 10;

        i++;  // i = i + 1;
        System.out.println(i);

        i--;  // i = i -1;
        System.out.println(i);

        boolean b = true;  // 논리반전
        System.out.println(!b);

        int j = 20;
        short s = (short) j;  // 강제 형변환

        int k = 10;
        int m = ~k; // 비트반전(0은 1로, 1은 0으로 변경)
        System.out.println(String.format("%032d", k));
        System.out.println(Integer.toBinaryString(m));

        String binaryString = String.format("%32s", Integer.toBinaryString(k)).replace(" ", "0");
        System.out.println(binaryString);
    }
}
