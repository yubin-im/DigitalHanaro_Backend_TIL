package unit04_controlStatement_arrays;

import java.util.Arrays;

public class ex23_array {
    public static void main(String[] args) {
        // 배열 Array
        // 1. 같은 타입의 데이터를 연속적 공간에 나열해 놓은 데이터 구조
        // 2. 생성시 크기가 지정되고 이후에는 크기 변경 불가
        // 3. 인덱스는 0부터 부여

        // 정수형 1차 배열
        // 1.
        int[] arrNum1 = new int[3];
        // 값이 0으로 초기화
        System.out.println(Arrays.toString(arrNum1));
        arrNum1[0] = 10;
        arrNum1[1] = 20;
        arrNum1[2] = 30;

        // 2.
        int[] arrNum2 = new int[]{10, 20, 30};

        // 3.
        int[] arrNum3 = {10, 20, 30};

        // 4.
        int arrNum4[] = {10, 20, 30};

        // 선언과 대입 분리 불가
//        int[] a;
//        a = {3, 4, 5};

        // 반복문을 이용한 데이터 읽기
        // 1. for
        for (int i = 0; i < arrNum1.length; i++) {
            System.out.println(arrNum1[i]);
        }

        // 2. for-each
        for (int num : arrNum1) {
            System.out.println(num);
        }


        System.out.println("--------------------------");
        // 연습 문제
        int[] nums = {10, 30, 20, 50, 40};

        // 1. 배열의 모든 요소값를 출력하시오.
        for (int num : nums) {
            System.out.println(num);
        }

        // 2. 배열의 값 갯수를 출력하시오.
        System.out.println("length: " + nums.length);

        // 3. 배열의 모든 값의 합계를 출력하시오.
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("sum: " + sum);

        // 4. 배열에서 20은 몇번째에 위치하는지 출력하시오.
        //    출력값: 3번째
        for (int i = 0; i < nums.length; i++) {
            if (20 == nums[i]) {
                System.out.println((i + 1) + "번째");
            }
        }
    }
}
