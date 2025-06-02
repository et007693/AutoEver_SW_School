package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        List<Menu> MenuList = new ArrayList<>();
        MenuList.add(new Menu("Americano", 2000, "Coffe", "그냥 커피", true));
        MenuList.add(new Menu("Latte", 4500, "Coffe", "우유 커피", true));
        MenuList.add(new Menu("Moca", 5500, "Coffe", "달달한 커피", true));

        for (Menu menu: MenuList) {
            System.out.println(menu);
            System.out.println();

        }
    }
}
