package 실습;
import java.util.Scanner;

public class Member {
    private String name;
    private int age;
    private char gender;
    private int job;

    Scanner sc = new Scanner(System.in);

    public void getName() {
        System.out.print("이름을 입력하세요 : ");
        name = sc.nextLine();
    }

    public void getAge() {
        System.out.print("나이를 입력하세요 : ");
        age = Integer.parseInt(sc.nextLine());

        if (age < 0 || age > 199) {
            System.out.println("정확한 나이를 입력하세요");
            getAge();
        }
    }

    public void getGender() {
        System.out.print("성별을 입력하세요 : ");
        gender = sc.nextLine().charAt(0);
        switch (gender) {
            case 'M':
            case 'm':
            case 'F':
            case 'f':
                break;
            default:
                System.out.println("성별을 잘못 입력 하셨습니다.");
                getGender();
        }
    }

    public void getJob() {
        System.out.print("직업을 입력하세요 : ");
        job = sc.nextInt();

        if (job < 1 || job > 4) {
            System.out.println("정확한 숫자를 입력해주세요");
            getJob();
        }
    }

    public void printInfo() {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        if (gender == 'M'  || gender == 'm') {
            System.out.println("성별 : 남성");
        } else {
            System.out.println("성별 : 여성");
        }
        switch (job) {
            case 1:
                System.out.println("직업 : 학생");
                break;
            case 2:
                System.out.println("직업 : 회사원");
                break;
            case 3:
                System.out.println("직업 : 주부");
                break;
            case 4:
                System.out.println("직업 : 무직");
                break;
        }
    }
}
