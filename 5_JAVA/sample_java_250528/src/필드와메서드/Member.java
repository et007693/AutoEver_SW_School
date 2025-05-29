package 필드와메서드;
// 필드 : 클래스 내부에 선언된 변수 (인스턴스 필드, 정적 필드, 지역 변수)
// 메서드 : 클래스 내부에 정의된 기능을 수행하는 함수 (순수 기능부분, 게터와 세터)

public class Member {
    private static String school = "가산고";
    private int num;
    private String name;
    private String addr;
    // 생성자의 주요 목적은 인스턴스 필드의 초기값을 부여하는 목정
    // 생성자는 클래스 이름과 동일하고 반환 타입이 없음
    public Member() {
        num = 100;
        name = "없음";
        addr = "없음";
    }

    public Member(int num, String name, String addr) {
        this.num = num;
        this.name = name;
        this.addr = addr;
    }

    // 정적  메서드 : 클래스 생성 시 생성되고, 객체와 무관
    public static String getSchool() {
        return school;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public static void setSchool(String school) {
        Member.school = school;
    }

    public void setNum(int num) {
        int test = 100;
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
