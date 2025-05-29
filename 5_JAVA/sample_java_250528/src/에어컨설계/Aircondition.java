package 에어컨설계;

import java.util.Calendar;

public class Aircondition {
    protected boolean isPower;
    protected int curTemp;
    protected int setTemp;
    protected int power;

    public void Aricon() {
        int[] montTemp = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        int month = Calendar.getInstance().get(Calendar.MONTH);
        this.curTemp = montTemp[month];
        this.setTemp = 24;
        this.power = 1;
        this.isPower = false;
    }

    public void powerOn() {
        isPower = true;
        System.out.println("전원이 켜졌습니다.");
    }

    public void powerOff() {
        isPower = false;
        System.out.println("전원이 켜졌습니다.");
    }

    public void setTemp(int setTemp) {
        this.setTemp = setTemp;
    }

    public void setWindStep(int power) {
        if (power >= 1 && power <= 3) this.power = power;
    }

    public void displayStatus() {
        System.out.println("==== 에어컨 상태 ====");
        System.out.println("전원: " + (isPower ? "ON" : "OFF"));
        System.out.println("현재 온도: " + curTemp);
        System.out.println("설정 온도: " + setTemp);
        System.out.println("바람 세기: " + power + "단계");
    }

    public void simulateTemperatureChange() {
        if (setTemp < curTemp) curTemp--;
        else if (setTemp > curTemp) curTemp++;
    }
}
