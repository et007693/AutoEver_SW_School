package DownCasting;

import java.util.ArrayList;

public class CastingMain {
    ArrayList<Animal> animalList = new ArrayList<>();
    public static void main(String[] args) {
        CastingMain downCasting = new CastingMain();
        downCasting.addAnimal();
    }
    public void addAnimal() {
        animalList.add(new Animal());
        animalList.add(new Human());
        animalList.add(new Tiger());
        animalList.add(new Eagle());

        for (Animal ani: animalList) {
            ani.move();

        }
    }

    public void testCasting() {
        for (int i = 0; i < animalList.size(); i++) {
            Animal ani = animalList.get(i); // 해당 인덱스의 요소를 추출
            if (ani instanceof Human h) {
                h.readBook();
            } else if (ani instanceof Tiger t) {
                t.hunting();
            } else if (ani instanceof Eagle e) {
                e.flying();
            } else {
                System.out.println("지원되지 않는 형입니다.");
            }

        }
    }
}
