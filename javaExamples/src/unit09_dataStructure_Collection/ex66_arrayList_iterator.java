package unit09_dataStructure_Collection;

import java.util.*;

public class ex66_arrayList_iterator {
    public static void main(String[] args) {
        // 컬렉션 프레임워크
        // List: ArrayList, LinkedList
        // Map: HashMap
        // Set: HashSet
        // ArrayList<String> fruits = new ArrayList<>();
        List<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("딸기");
        fruits.add("망고");

        System.out.println(fruits.size());
        fruits.add(0, "레몬");
        fruits.remove(1);
        fruits.set(1, "복숭아");

        // 정렬
        Collections.sort(fruits);
        System.out.println(fruits);
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println(fruits);

        // 초기화
//        fruits.clear();
//        System.out.println(fruits);

        // Iterator (반복자)
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
