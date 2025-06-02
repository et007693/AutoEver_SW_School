package 열거클래스;

public class EnumMain {
    public static void main(String[] args) {
        Developer developer = new Developer("곰돌이사육사", DevType.FRONTEND, Career.SENIOR, Gender.MALE);
        developer.devInfo();
    }
}
