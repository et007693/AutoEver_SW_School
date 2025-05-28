package 반복문;

import java.util.Scanner;

public class EnhancedEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 77, 88, 999, 23};
        for(int e:arr) {
            // 값을 복사해서 순회하기 때문에, 원본 변경 X
            e += 100;
            System.out.print(e + " ");
        }
        System.out.println();
        for(int e: arr) {
            System.out.print(e + " ");
        }
    }
}
