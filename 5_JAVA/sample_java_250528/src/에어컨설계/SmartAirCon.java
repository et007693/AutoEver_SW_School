package 에어컨설계;

public class SmartAirCon extends Aircondition {
    private boolean autoMode = false;

    public void autoSetting(boolean onOff) {
        this.autoMode = onOff;
        if (autoMode) {
            this.setedTemp = 20;
            this.windPower = 2;
            System.out.println("스마트 에어컨: 자동 설정 모드 ON (20도 / 2단계)");
        } else {
            System.out.println("스마트 에어컨: 자동 설정 모드 OFF (수동 설정 가능)");
        }
    }

    public boolean isAutoMode() {
        return autoMode;
    }

    @Override
    public void setTemp(int temp) {
        if (!autoMode) this.setedTemp = temp;
        else System.out.println("자동 모드에서는 온도 설정이 불가능합니다.");
    }

    @Override
    public void setWindPower(int step) {
        if (!autoMode && step >= 1 && step <= 3) this.windPower = step;
        else if (autoMode) System.out.println("자동 모드에서는 바람 세기 설정이 불가능합니다.");
    }
}