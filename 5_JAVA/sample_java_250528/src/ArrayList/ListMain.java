package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(); // List 인터페이스의 참조변수에 ArrayList 객체 주소 대입
        // 요소 추가 : add
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add(1, "Grape");
        System.out.println(fruits);

        // 요소 가져오기 : get
        System.out.println(fruits.get(1));

        // 요소 제거 : remove
        fruits.remove(2);
        System.out.println(fruits);

        // 크기 : size
        System.out.println(fruits.size());

        // 반복하기 : for
        for (String f : fruits) {
            System.out.print(f + " ");
        }
        System.out.println();

        // 포함여부 확인 : contains
        System.out.println(fruits.contains("banana"));

    }
}
