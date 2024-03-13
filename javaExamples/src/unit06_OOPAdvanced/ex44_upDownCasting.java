package unit06_OOPAdvanced;

class People {
    void think() {
        System.out.println("생각한다.");
    }
}

class Man extends People {
    @Override
    void think() {
        System.out.println("남자가 생각한다.");
    }

    void shave() {
        System.out.println("면도한다.");
    }
}

class Woman extends People {
    @Override
    void think() {
        System.out.println("여자가 생각한다.");
    }

    void makeup() {
        System.out.println("화장한다.");
    }
}

public class ex44_upDownCasting {
    public static void main(String[] args) {
        // 업 캐스팅: 자식 객체가 부모 클래스 타입을 가지는 것
        People people = new Man();
        people.think();

        // 다운 캐스팅: 자식 객체가 부모 클래스의 타입으로 변경되었다가 다시 자식클래스 타입을 가지는 것
//        ((Man) People).shave();

        // 다형성을 이용해서 Man 객체와 Woman 객체도 전달
        myFunc(new Man());
        myFunc(new Woman());
    }

    static void myFunc(People p) {
        // instanceof 연산자 : 객체 타입을 확인하는 연산자.
        if (p instanceof Man) {
            ((Man) p).shave();
        }
        if (p instanceof Woman) {
            ((Woman) p).makeup();
        }
    }
}
