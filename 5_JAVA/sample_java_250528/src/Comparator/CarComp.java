package Comparator;

public class CarComp implements Comparable<CarComp>{
    String name;
    int year;
    String color;

    public CarComp(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public int compareTo(CarComp o) {
        if (this.year == o.year) {
            int rst = this.name.compareTo(o.name);
            if (rst != 0) return rst;
            else {
                return this.color.compareTo(o.color);
            }
        } else if (this.year < o.year) return -1; // 정렬하지 않는 조건
        else return 1; // 정렬하는 조건, 오름차순 정렬
    }
}
