package 반복문;
// 양의 정수 n을 입력 받아 n*n 크기의 행렬을 출력하는 프로그램 작성
// 이 대 행렬의 값은 1부터 시작하여 왼쪽에서 오른쪽, 위에서 아래 순서대로 채워 넣음


import java.util.Scanner;

public class SquareEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");

        int num = sc.nextInt();

//        for (int i = 0; i < num; i++) {
//            for (int j = 1; j <= num; j++) {
//                System.out.print(num * i + j + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= num*num; i++) {
            System.out.printf("%4d", i);
            if (i % num == 0) System.out.println();
        }
    }
}
