package Comparator;

import java.util.TreeSet;

public class CompMain {
    public static void main(String[] args) {
        TreeSet<CarComp> set = new TreeSet<>();
        set.add(new CarComp("Cona", 2022, "white"));
        set.add(new CarComp("Santafe", 2018, "grey"));
        set.add(new CarComp("Grandeur", 2016, "white"));
        set.add(new CarComp("GV80", 2023,  "black"));
        set.add(new CarComp("GV80", 2023,  "white"));

        for (CarComp car: set) {
            System.out.println(car.name + " : " + car.year);
        }
    }
}
