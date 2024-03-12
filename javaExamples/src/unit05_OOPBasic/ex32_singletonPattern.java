package unit05_OOPBasic;

// 싱글톤(Singleton): 프로그램안에서의 유일한 클래스 객체
// new를 통해서 여러개의 객체를 만들 수 있지만 모두 주소값이 같은 객체들이다.
// 유일한 객체가 필요한 이유는 유일한 정보를 저장하기 위함이다.

// 일반 객체
class FishBun {
    int bunNo = 10;
}

// 싱글톤 객체
class UniqueFishBun {
    int bunNo = 30;
    private static UniqueFishBun singleton;  // null

    public static UniqueFishBun getInstance() {
        if (singleton == null) {
            singleton = new UniqueFishBun();
        }
        return singleton;
    }
}

public class ex32_singletonPattern {
    public static void main(String[] args) {
        // 싱글톤 객체
        UniqueFishBun uBun1 = UniqueFishBun.getInstance();
        UniqueFishBun uBun2 = UniqueFishBun.getInstance();

        // 아래 두 객체 주소값은 같다 (싱글톤 특징)
        System.out.println(uBun1); //3b07d329
        System.out.println(uBun2); //3b07d329


        // 일반 객체
        FishBun bun1 = new FishBun();
        FishBun bun2 = new FishBun();
        FishBun bun3 = new FishBun();

        // 아래 두 객체 주소값은 다르다.
        System.out.println(bun1); //3b07d329
        System.out.println(bun2); //41629346

        bun1.bunNo = 20;
        System.out.println(bun1.bunNo);
        System.out.println(bun2.bunNo);

        // 일반객체는 일관된 데이터를 저장할 수 없다.
        // 객체의 생성과 소멸이 자유롭게 이루어지고, GC(Garbage Colletor)가 자동으로 메모리를 회수한다.
    }
}
