package unit05_OOPBasic;

// 연습문제 - 싱글톤 만들기
// 클래스 이름 : HanaAccount
// 필드 : 계좌번호(1234), 고객이름(홍길동), 잔액(1000), 이자율(년3%)
// 메소드 : 입금(+100), 출금(-100), 이자계산(1년후 잔액), 잔액조회
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

    public void withdraw() {
        this.balance = balance - 100;
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

public class ex33_q {
    public static void main(String[] args) {
        // 싱글톤을 호출 후
        // 1. 입금 메소드 호출
        // 2. 출금 메소드 호출
        // 3. 이자계산은 이자율을 읽어서 참조한다.
        //    이자계산후 잔액 증가한다.
        // 4. 최종 잔액을 출력한다.
        HanaAccount hanaAccount = HanaAccount.getInstance();

        hanaAccount.deposit();
        hanaAccount.withdraw();
        hanaAccount.interest();
        System.out.println("총 잔액: " + hanaAccount.getBalance());
    }
}