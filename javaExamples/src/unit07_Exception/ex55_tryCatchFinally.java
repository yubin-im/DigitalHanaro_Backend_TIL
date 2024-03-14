package unit07_Exception;

public class ex55_tryCatchFinally {
    public static void main(String[] args) {
        try {
            int[] nums = {10, 20, 30};
//            System.out.println(nums[3]);
//            System.out.println(10 / 0);
            String str = null;
            str.toLowerCase();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 예외발생!");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("산술 예외발생!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("그외 예외발생!");
            e.printStackTrace();
        } finally {
            // 예외가 발생하든 안하든 무조건 호출되는 블록
            // 마무리 정리하는 코드
            System.out.println("정리하는 코드");
        }

    }
}
