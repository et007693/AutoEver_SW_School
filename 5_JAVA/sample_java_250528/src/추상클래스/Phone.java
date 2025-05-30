package 추상클래스;

public abstract class Phone {
    private String name;
    private boolean isPower;
    public Phone(String name) {
        this.name = name;
    }

    public void setPower(boolean power) {
        isPower = power;
        if (isPower) {
            System.out.println("Phone Power ON");
        } else {
            System.out.println("Phone Power OFF");
        }
    }
    abstract void call(); // 추상 메서드 : 자식이 반드시 오버라이딩을 해야 함
}
