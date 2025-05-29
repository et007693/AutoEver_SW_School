package 에어컨설계;

public class PortableAircon extends Aircondition{
    private int battery = 100;

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("배터리 잔량 : " + battery);
    }
}
