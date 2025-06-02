package ArrayList;

public class Menu {
    String name;
    int price;
    String category;
    String desc;
    boolean isTax;

    public Menu(String name, int price, String category, String desc, boolean isTax) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.desc = desc;
        this.isTax = isTax;
    }

    @Override
    public String toString() {
        return "이름 : " + name + "\n" + "이름" + "가격 : " + price + "\n" + "분류 : " + category + "\n" + "설명 : " + desc + "\n" + "세금 여부 : " + isTax;

    }
}
