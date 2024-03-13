package unit06_OOPAdvanced;

// 클래스의 상속:
// 부모 클래스의 필드, 메소드를 자식 클래스가 물려받는 것
// 사용 이유:
// 코드 중복을 피할 수 있고 계층적인 구조로 코드를 설계할 수 있다.

// 코드 중복을 줄이는 방법:
// 0. 반복문이나 배열/리스트를 사용한다.
// 1. 함수로 재사용한다.
// 2. 클래스(필드+함수)로 재사용한다.
// 3. 클래스 상속을 이용한다.
// 4. 추상화 클래스나 인터페이스 사용

class Animal {
    int age = 10;

    void eat() {
        System.out.println("먹는다.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("짖는다.");
    }
}

class Cat extends Animal {
    void grooming() {
        System.out.println("손질한다.");
    }
}

public class ex36_inheritance {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.age);
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        System.out.println(cat.age);
        cat.eat();
        cat.grooming();
    }
}
