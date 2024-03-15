package unit09_dataStructure_Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ex68_map {
    public static void main(String[] args) {
        // Map
        // 키와 값으로 된 데이터 구조
        // JSON, XML 데이터 구조와 연결 역할
        // 인덱스와 순서는 없다.
        Map<String, String> map = new HashMap<>();
        map.put("username", "hong");
        map.put("password", "1234");
        System.out.println(map);

        System.out.println(map.get("username"));
        System.out.println(map.get("password"));

        // 전체 출력
        // 1. for each
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
        System.out.println("------------------------");

        // 2. Iterator
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println(map.get(it.next()));
        }
    }
}
