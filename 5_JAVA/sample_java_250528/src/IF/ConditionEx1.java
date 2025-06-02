package IF;
import java.util.Scanner;

public class ConditionEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("기상 시간 입력 : ");

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int calc = hour*60 + minute-45;

        if (calc < 0) {
            calc = 24*60 + calc;
        }
        System.out.println((calc / 60) + " " + (calc % 60));
    }
}
