package 추상클래스;

public class SmartPhone extends Phone{
    public SmartPhone(String name) {
        super(name);
    }

    @Override
    void call() {
        System.out.println("부모의 요청으로 call 기능 구현");
    }

    public void internet() {
        System.out.println("인터넷 기능을 추가함");
    }
}
