package unit07_Exception;

public class ex57_q {
    public static void main(String[] args) {
        // 연습 문제
        // 출금 함수 동작시 OverdrawnException이 발생할 수 있도록 사용자 정의 예외 상황을 만들어 처리하시오.
        HanaAccount hanaAccount = HanaAccount.getInstance();

        try {
            hanaAccount.withdraw(500);
            hanaAccount.withdraw(500);
            hanaAccount.withdraw(500);
        } catch (OverdrawnException e) {
            e.printMessage();
        }
    }
}

class HanaAccount {
    private static HanaAccount hanaAccount;
    private int account = 1234;
    private String name = "홍길동";
    private int balance = 1000;
    private double interestRate = 0.03;

    public void deposit() {
        this.balance = balance + 100;
        System.out.println("입금 후 잔액: " + balance);
    }

    public void withdraw(int money) throws OverdrawnException {
        this.balance = balance - money;

        if (balance < 0) {
            OverdrawnException e = new OverdrawnException();
            e.message = "잔액이 부족합니다. ";
            throw e;
        }

        System.out.println("출금 후 잔액: " + balance);
    }

    public void interest() {
        int interest = (int) Math.round(balance * interestRate);
        this.balance = balance + interest;
        System.out.println("이자 " + interest + "원이 추가된 잔액: " + balance);
    }

    public int getBalance() {
        return this.balance;
    }

    public static HanaAccount getInstance() {
        if (hanaAccount == null) {
            hanaAccount = new HanaAccount();
        }
        return hanaAccount;
    }
}

class OverdrawnException extends Exception {
    String message = "";

    public void printMessage() {
        System.out.println(this.message);
    }
}

