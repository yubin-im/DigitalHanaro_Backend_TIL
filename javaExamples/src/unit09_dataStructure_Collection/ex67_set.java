package unit09_dataStructure_Collection;

import java.util.HashSet;
import java.util.Set;

public class ex67_set {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("변사또");
        set.add("춘향이");

        // 중복 허용 불가
        boolean isAdded = set.add("홍길동");
        System.out.println(isAdded);
        System.out.println(set);

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        setA.add(10);
        setA.add(20);
        setA.add(30);
        setB.add(30);
        setB.add(40);
        setB.add(50);

        //교집합
        //setA.retainAll( setB );
        //System.out.println( setA ); //교집합으로 변경됨.

        //합집합
        setA.addAll(setB);
        System.out.println(setA);//[50, 20, 40, 10, 30]

        //차집합
        setA.removeAll(setB);
        System.out.println(setA);//[20, 10]
    }
}
