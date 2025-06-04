package ComparatorPrac;
// Comparator : 두 개의 입력을 받아 정렬해주는 클래스

import java.util.Comparator;

public class CarMain {
    public static void main(String[] args) {

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

class CarComparator implements Comparator<CarComparator> {
    @Override
    public int compare(CarComparator o1, CarComparator o2) {
//        if (o1.price)
    }

    @Override
    public Comparator<CarComparator> reversed() {
        return Comparator.super.reversed();
    }
}