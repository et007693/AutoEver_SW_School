package 참조타입;

public class RefType {
    public static void main(String[] args) {
        String name1 = "안유진";
        String name2 = "안유진";
        String name3 = new String("안유진");
        String name4 = new String("장원영");

        if (name1 == name3) {
            System.out.println("name1과 name2의 참조하는 주소가 같음");
        } else {
            System.out.println("name1과 name2의 참조하는 주소가 다름");
        }

        if (name1.equals(name4)) {
            System.out.println("name1과 name3의 내용이 같음");
        } else {
            System.out.println("name1과 name3의 내용이 다름");
        }
    }
}
