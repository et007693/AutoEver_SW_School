package Car;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car car;

        System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
        int location = sc.nextInt();

        System.out.print("이동할 승객 수 입력 : ");
        int passenger = sc.nextInt();

        System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        int carType = sc.nextInt();

        System.out.print("부가 기능 [1]ON [2]OFF : ");
        int optionType = sc.nextInt();

        System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
        int weatherOption = sc.nextInt();

        System.out.print("차 이름 입력 : ");
        String carName = sc.next();

        switch (carType) {
            case 1:
                car = new SportsCar(carName);
                break;
            case 2:
                car = new Sedan(carName);
                break;
            case 3:
                car = new Bus(carName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + carType);
        };

        car.setMovecount(passenger);
        car.setDistance(location);
        car.setMode(optionType);
        car.setWeather(weatherOption);
        car.setConsume();
        car.setOilcount();
        car.setPrice();
        car.setTime();

        if (car instanceof Audio) {
            ((Audio) car).printAudio();
        }
        if (car instanceof Aircon) {
            ((Aircon) car).printAircon();
        }
        if (car instanceof AutoDrive) {
            ((AutoDrive) car).printAutoDrive();
        }

        car.printResult();
    }
}
