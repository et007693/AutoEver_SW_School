package 상속과다형성;

public class Prototype {
    boolean isPower;
    int channel;
    int volume;

    public Prototype(boolean isPower, int cnl, int vol) {
        this.isPower = isPower;
        channel = cnl;
        volume = vol;
    }

    public void setChannel(int cnl) {
        if (cnl > 0 && cnl < 1000){
            channel = cnl;
        } else System.out.println("채널 설정 범위가 아닙니다.");
    }

    public void setPower(boolean power) {
        isPower = power;
    }
}
