package ArraysClass;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMain {
    public static void main(String[] args) {
        String[] fruits = {"Kiwi","Orange", "Apple", "Banana", "Melon", "Mango","Watermelon","Cherry","Plum","Peach"};
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2); // 사전순 정렬
                    }
                    return -1;
                }
            }
        });
        System.out.println(Arrays.toString(fruits));
    }
}
