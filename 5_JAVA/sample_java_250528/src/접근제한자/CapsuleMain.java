package 접근제한자;

public class CapsuleMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.money = "100억";
        System.out.println(child.getName());
        System.out.println(child.getMoney());
        System.out.println(child.getAddr());
    }
}