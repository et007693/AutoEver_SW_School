package ComparatorPrac;
// Comparator : 두 개의 입력을 받아 정렬해주는 클래스

import java.util.Comparator;
import java.util.TreeSet;

public class CarMain {
    public static void main(String[] args) {
        TreeSet<Car> set = new TreeSet<>(new CarComparator());
        set.add(new Car(1999, "소나타", 2000));
        set.add(new Car(1988, "프라이드", 700));
        set.add(new Car(2001, "그랜저", 2800));
        set.add(new Car(2012, "싼타페", 3500));
        set.add(new Car(2022, "GV80", 7000));

        for (Car car: set) {
            System.out.println("이름 : " + car.name + "가격 : " + car.price);
        }
    }
}

class Car {
    int year;
    String name;
    int price;

    public Car(int year, String name, int price) {
        this.year = year;
        this.name = name;
        this.price = price;
    }
}

class CarComparator implements Comparator<Car> {
    @Override // 내림차순
    public int compare(Car o1, Car o2) {
        if (o1.price < o2.price) return 1;
        else return -1;
    }

    @Override
    public Comparator<Car> reversed() {
        return Comparator.super.reversed();
    }
}