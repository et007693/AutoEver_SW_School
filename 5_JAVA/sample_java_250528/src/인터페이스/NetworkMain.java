package 인터페이스;

import java.util.Scanner;

public class NetworkMain {
    public static void main(String[] args) {
        NetworkAdaptar adaptar = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("연결할 네트워크 선택하세요 [1]WiFi [2]5G [3]LTE :  ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                adaptar = new Wifi("KT megapass");
                adaptar.connect();
                break;

            case 2:
                adaptar = new FiveG("SK Telecom");
                adaptar.connect();
                break;

            case 3:
                adaptar = new LTE("LG U+");
                adaptar.connect();
                break;
            default:
                System.out.println("네트워크 선택이 잘못되었습니다.");
        }
    }
}
