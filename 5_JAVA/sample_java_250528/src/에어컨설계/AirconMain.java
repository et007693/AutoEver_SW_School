package 에어컨설계;
// 1. 기본 에어컨 만들기
// - 전원 On, Off
// - 현재 온도 표시 기능
// - 설정 온도 표시 기능
// - 바람세기(1단/2단/3단)
// - 현재 상태 출력 기능 : 전원, 현재온도, 설정온도, 바람세기

// 2. 스마트 에어컨
// - 자동 설정 기능 : 20도 설정, 2단계

// 3. 휴대용 에어컨
// - 배터리 표시기능 추가

import java.util.Scanner;

public class AirconMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("에어컨 종류 선택 : 1:기본 / 2:스마트 / 3:휴대용");
        int type = sc.nextInt();
        Aircondition ac = null;

        switch (type) {
            case 1:
                ac = new Aircondition();
                ac.powerOn();
                System.out.println("설정 온도 입력 : ");
                ac.setTemp(sc.nextInt());
                System.out.println("바람 세기 입력 : ");
                ac.setWindStep(sc.nextInt());

            case 2:
                ac = new SmartAircon();
                ac.powerOn();
                System.out.println("스마트 에어컨 자동모드 설정");
                boolean auto = sc.nextBoolean();
                ac.autoSet();
                if (!auto) {
                    System.out.println("설정 온도 입력");
                    System.out.print("설정 온도 입력: ");
                    ac.setTemp(sc.nextInt());
                    System.out.print("바람 세기 입력 (1~3): ");
                    ac.setWindStep(sc.nextInt());
                }
            case 3:
                ac = new PortableAircon();
                ac.powerOn();
                System.out.print("설정 온도 입력: ");
                ac.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력 (1~3): ");
                ac.setWindStep(sc.nextInt());
        }

        ac.powerOn();
        System.out.println();

    }
}
