import java.util.Arrays;
import java.util.Scanner;

// 10번 문제: 괄호의 개수
public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("괄호를 입력하세요: ");
        String parentheses = scanner.nextLine();

        checkParentheses(parentheses);
    }

    static void checkParentheses(String parentheses) {
        int open = 0;
        int close = 0;
        char[] parenthesesArr = parentheses.toCharArray();

        for (int i = 0; i < parenthesesArr.length; i++) {
            if (parenthesesArr[i] == '(') {
                open++;
            } else if (parenthesesArr[i] == ')') {
                close++;
            } else {
                System.out.println("괄호가 아닌 문자가 포함되어 있습니다.");
            }
        }

        System.out.println("여는 괄호 개수: " + open);
        System.out.println("닫는 괄호 개수: " + close);
    }
}
