package 에어컨설계;

import java.util.Calendar;

public class Aircondition {
    protected boolean isPower;
    protected int curTemp;
    protected int setedTemp;
    protected int windPower;

    public void Aircondition() {
        int[] montTemp = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        int month = Calendar.getInstance().get(Calendar.MONTH);
        this.curTemp = montTemp[month];
        this.setedTemp = 24;
        this.windPower = 1;
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

    public void setTemp(int temp) {
        this.setedTemp = temp;
    }

    public void setWindPower(int power) {
        if (power >= 1 && power <= 3) this.windPower = power;
    }

    public void displayStatus() {
        System.out.println("==== 에어컨 상태 ====");
        System.out.println("전원: " + (isPower ? "ON" : "OFF"));
        System.out.println("현재 온도: " + curTemp);
        System.out.println("설정 온도: " + setedTemp);
        System.out.println("바람 세기: " + windPower + "단계");
    }

    public int getCurrTemp() { return curTemp; }
    public int getSetTemp() { return setedTemp; }
    public boolean isPowerOn() { return isPower; }
    public int getWindStep() { return windPower; }

    public void simulateTemperatureChange() {
        if (setedTemp < curTemp) curTemp--;
        else if (setedTemp > curTemp) curTemp++;
    }
}
