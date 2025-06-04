package ComparatorPrac;

import java.util.TreeSet;

public class StudentMain {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();

        students.add(new Student("안유진", 90));
        students.add(new Student("장원영", 100));
        students.add(new Student("카리나", 84));
        students.add(new Student("윈터", 91));
        students.add(new Student("사나", 87));

        for (Student s: students) {
            System.out.println("이름 : " + s.name + "\n" + "성적 : " + s.score);
            System.out.println();
        }
    }
}

class Student implements Comparable<Student> {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student s) {
        if (this.score < s.score) return 1;
        else if (this.score > s.score) return -1;
        else return 0;
    }
}