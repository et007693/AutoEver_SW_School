package ArrayListApply;

import java.math.BigDecimal;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("\n==== 주문 관리 시스템 ====");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 제거");
            System.out.println("3. 제품 목록 보기");
            System.out.println("4. 제품 보기");
            System.out.println("5. 최종 가격 계산 (세금 포함)");
            System.out.println("6. 종료");
            System.out.print("원하는 작업을 선택하세요: ");
            int choice = sc.nextInt();
            sc.nextLine();  // 버퍼 비우기

            switch (choice) {
                case 1:
                    System.out.print("제품 이름을 입력해주세요 : ");
                    String addName = sc.nextLine();
                    System.out.print("제품 가격을 입력해주세요 : ");
                    String price = sc.nextLine();
                    order.addItem(new Product(addName, price));
                    System.out.println(addName + "이 추가되었습니다.");
                    break;

                case 2:
                    System.out.print("제거할 제품의 이름을 입력해주세요 : ");
                    String removeName = sc.nextLine();
                    if (order.removeItem(removeName)) {
                        System.out.println(removeName + "의 제거가 완료되었습니다.");
                    } else {
                        System.out.println("해당 이름의 제품을 찾을 수 없습니다.");
                    }
                    break;

                case 3:
                    System.out.println("==== 현재 제품 목록 ====");
                    for (Product p : order.getProducts()) {
                        System.out.println(p.getName() + " - $" + p.getPrice());
                    }
                    break;

                case 4:
                    System.out.print("검색할 제품의 이름을 입력해주세요 : ");
                    String findName = sc.nextLine();
                    Product p = order.getItem(findName);
                    if (p != null) {
                        System.out.println(p.getName() + " - $" + p.getPrice());
                    } else {
                        System.out.println("해당 이름의 제품을 찾을 수 없습니다.");
                    }

                case 5:
                    System.out.print("세율을 입력하세요 (예: 0.06 for 6%): ");
                    BigDecimal taxRate = new BigDecimal(sc.nextLine());
                    BigDecimal finalPrice = order.calculateFinalPrice(taxRate);
                    System.out.println("세금이 포함된 최종 가격: $" + finalPrice);
                    break;

                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("잘못된 명령입니다.");
            }
        }


    }
}
