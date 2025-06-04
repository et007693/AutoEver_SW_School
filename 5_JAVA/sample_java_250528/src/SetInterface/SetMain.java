package SetInterface;

import java.util.HashSet;

public class SetMain {
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<>();
//        set.add("곰돌이");
//        set.add("안유진");
//        set.add("정상기");
//        set.add("장원영");
//        set.add(new String("정상기"));
//        for (String e : set) {
//            System.out.println(e + " ");
//        }


        HashSet<Member> set = new HashSet<>();
        set.add(new Member(1001, "유나"));
        set.add(new Member(1002, "채원"));
        set.add(new Member(1002, "지수"));
        set.add(new Member(1003, "카리나"));
        for (Member e : set) {
            System.out.println(e);
        }

    }
}

class Member {
    int id;
    String name;
    @Override
    public int hashCode() {
        return id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member member) {
            return this.id == member.id;
        }
        return false;
    }
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "아이디 : " + id + "\n" + "이름 : " + name + "\n";
    }
}
