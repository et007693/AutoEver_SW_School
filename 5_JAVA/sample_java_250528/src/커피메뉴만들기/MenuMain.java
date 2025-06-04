package 커피메뉴만들기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuMain {
    static Map<String, MenuInfo> map = new HashMap<>();
    public static void main(String[] args) {
        makeMenu();
        selectMenu();

    }
    static void makeMenu() {
        map.put("Americano", new MenuInfo("Americano", 2000, "Coffee", "기본커피"));
        map.put("Espresso", new MenuInfo("Americano", 2000, "Coffee", "진한커피"));
        map.put("Latte", new MenuInfo("Americano", 4500, "Coffee", "우유커피"));
    }
    static void selectMenu() {
        Scanner sc = new Scanner(System.in);
        String key;
        while (true) {
            System.out.println("메뉴를 선택하세요");
            System.out.println("[1]메뉴 보기 [2]메뉴 조회 [3]메뉴 추가 [4]메뉴 삭제 [5]메뉴 수정 [6]종료");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=".repeat(10) + "메뉴 보기" + "=".repeat(10));
                    for (String k : map.keySet()) {
                        System.out.println("메뉴 : " + map.get(k).getName());
                        System.out.println("가격 : " + map.get(k).getPrice());
                        System.out.println("분류 : " + map.get(k).getCategory());
                        System.out.println("설명 : " + map.get(k).getDesc());
                    }
                    break;

                case 2:
                    System.out.print("조회할 메뉴를 입력하세요. : ");
                    key = sc.nextLine();
                    if (map.containsKey(key)) {
                        System.out.println("메뉴 : " + map.get(key).getName());
                        System.out.println("가격 : " + map.get(key).getPrice());
                        System.out.println("분류 : " + map.get(key).getCategory());
                        System.out.println("설명 : " + map.get(key).getDesc());
                    } else {
                        System.out.println("해당 메뉴가 존재하지 않습니다.");
                    }
                    break;

                    case 3:
                        System.out.println("추가할 메뉴를 입력하세요 : ");
                        key = sc.nextLine();
                        if (!map.containsKey(key)) {
                            System.out.println("가격 입력 : ");
                            int price = sc.nextInt();
                            System.out.println("분류 입력 : ");
                            String cate = sc.nextLine();
                            System.out.println("설명 입력 : ");
                            String desc = sc.nextLine();
                            map.put(key, new MenuInfo(key, price, cate, desc));
                        } else {
                            System.out.println("해당 메뉴가 이미 존재합니다.");
                        }
                        break;

                case 4:
                    System.out.println("삭제할 메뉴를 입력하세요 : ");
                    key = sc.nextLine();

                    if (map.containsKey(key)) {
                        map.remove(key);
                        System.out.println("메뉴를 삭제하였습니다.");
                    } else {
                        System.out.println("삭제할 메뉴가 없습니다.");
                    }
                    break;

                case 5:
                    System.out.println("수정할 메뉴를 입력하세요");
                    key = sc.nextLine();

                    if (map.containsKey(key)) {
                        System.out.println("가격 입력 : ");
                        int price = sc.nextInt();
                        System.out.println("분류 입력 : ");
                        String cate = sc.nextLine();
                        System.out.println("설명 입력 : ");
                        String desc = sc.nextLine();
                        map.replace(key, new MenuInfo(key, price, cate, desc));
                        System.out.println("값 변경이 완료되었습니다.");
                    } else {
                        System.out.println("수정할 메뉴가 없습니다.");
                    }
                    break;

                case 6:
                    System.out.println("메뉴를 종료합니다.");
                    return;
            }
        }
    }
}
