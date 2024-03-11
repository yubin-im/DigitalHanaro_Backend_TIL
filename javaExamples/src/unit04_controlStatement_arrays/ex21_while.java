package unit04_controlStatement_arrays;

public class ex21_while {
    public static void main(String[] args) {
        // while 문
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        // do-while 문
        // 적어도 한번은 실행 후 조건 비교한다.
        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 5);
    }
}
