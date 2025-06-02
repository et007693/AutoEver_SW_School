package FieldMethod;

public class OOP1 {
    public static void main(String[] args) {
        Member member1 = new Member();
        member1.setNum(100);
        member1.setName("장원영");
        member1.setAddr("인천시");
        Member member2 = new Member(200, "안유진", "대전시");

    }
}
