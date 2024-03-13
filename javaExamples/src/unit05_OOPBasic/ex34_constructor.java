package unit05_OOPBasic;

// 생성자 함수 (Constructor)
// 클래스 객체가 생성될 때 (new 인스턴스) 자동으로 호출되는 메소드
// 용도:
class Book {
    // 속성
    int price = 1000;

    // 행동
    void read() {
        System.out.println("책을 읽는다.");
    }

    // 생성자 함수
    public Book() {
        this.price = 2000;
        System.out.println("생성자 함수 호출");
    }
}

public class ex34_constructor {
    public static void main(String[] args) {
        Book book = new Book();
        System.out.println(book.price);
    }
}
