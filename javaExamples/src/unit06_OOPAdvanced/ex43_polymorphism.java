package unit06_OOPAdvanced;

// 다형성 (Polymorphism)
// 자식 클래스 객체가 자기 클래스 또는 부모 클래스의 타입을 모두 가질 수 있는것
// 타입의 유연성을 가지기 위한 것
// -> 타입이 정확하지 않더라도 객체(참조변수)를 전달 가능
class Parent {
    String name = "Parent";

    void parentMethod() {
        System.out.println("Parent 내 이름은" + this.name);
    }
}

class Child extends Parent {
    String name = "Child";

    void childMethod() {
        System.out.println("Child 내 이름은 " + this.name);
    }
}

public class ex43_polymorphism {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        System.out.println(p1.name);
        Child c1 = new Child();
        System.out.println(c1.name);

        // 업 캐스팅: 자식객체가 부모 클래스 타입을 가지는 것
        Parent p2 = new Child();  // 자동 형변환
        System.out.println(p2.name);

        // 다운 캐스팅: 자식 객체가 자녀 클래스의 타입을 갖는 것
        Child c2 = (Child) p2;  // 강제 형변환
        System.out.println(c2.name);

        //                 v다운캐스팅 v 업캐스팅
        //                 +-------+--------+
        //Child클래스 객체 = | Child + Parent |
        //                 +-------+--------+


        // 4가지 형태
        Parent a = new Parent();
        Child b = new Child();
        Parent c = new Child();  // 업 캐스팅
        Child e = (Child) c;  // 다운 캐스팅
        //Child d = new Parent();  // 불가능- 다형성과 무관 
    }
}
