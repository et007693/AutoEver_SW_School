package 조건문;

import java.util.Arrays;
import java.util.Scanner;

public class ConditionEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        String[] num = sc.next().split("");
        int max = 0;

        for (String n : num) {
            max = Math.max(Integer.parseInt(n), max);
        }

        System.out.println(max);

    }
}
