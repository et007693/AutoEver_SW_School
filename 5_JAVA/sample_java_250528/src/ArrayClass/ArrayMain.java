package ArrayClass;
// 배열을 다루기 위한 메소드


import java.util.Arrays;

public class ArrayMain {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 7, 9, 8, 2, 1};
        Arrays.sort(arr);
        System.out.println(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

    }
}