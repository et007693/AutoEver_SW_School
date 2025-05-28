package 반복문;

import java.util.Scanner;

public class IterableEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        int sum = 0;
        while (num > 0) {
            sum += num;
            num--;
        }

        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
