package unit05_OOPBasic;

// 접근 제한자: 클래스, 함수, 변수 앞에 위치하여 접근을 제한할 때 사용
// public: 같은 폴더(패키지) + 다른 폴더의 클래스에서 접근 가능
// protected: 같은 폴더 + 상속관계
// default: 같은 폴더
// private: 같은 클래스안에서 접근 가능 (캡슐화)
// Getter/Setter 함수를 통해서 접근하도록 허용
class Hong {
    String name = "홍길동";  // default
    public int age = 30;
    protected int korScore = 80;
    private int engScore = 90;

    // private 변수는 Getter/Setter 함수를 통하여 접근
    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    void printEngScore() {
        System.out.println(this.engScore);
    }
}

public class ex29_accessModifier {
    public static void main(String[] args) {
        Hong hong = new Hong();

        System.out.println(hong.getEngScore());
        hong.setEngScore(70);
        System.out.println(hong.getEngScore());
    }
}
