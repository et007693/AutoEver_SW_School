package 다형성;

import java.util.Scanner;

public class DriveMain {
    public static void main(String[] args) {
        Driver driver = new Driver("곰돌이사육사");
        SportsCar ferrari = new SportsCar();
        Sedan g80 = new Sedan();
        SUV x60 = new SUV();

        Scanner sc = new Scanner(System.in);
        System.out.print("운전하고 싶은 차 선택 [1]페라리 [2]현대 [3]제네시스.");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1: driver.drive(ferrari); break;
            case 2: driver.drive(g80); break;
            case 3: driver.drive(x60); break;
            default:

        }
    }
}

