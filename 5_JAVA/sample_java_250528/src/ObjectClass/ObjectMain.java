package ObjectClass;

public class ObjectMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        // 클래스명@16진수 해시코드, 오버라이딩 후 사용하는 경우가 많음
        System.out.println(student1.toString());
        System.out.println(student1);

        // equals() : 두 객체가 같은지 비교
        Student student2 = new Student();
        System.out.println(student1.equals(student2));
    }
}

class Student {

}