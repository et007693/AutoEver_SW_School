package Car;

public class Bus extends Car implements Aircon, AutoDrive{
    public Bus(String name){
        setKmperliter(5);
        setSpeed(150);
        setOiltanksize(100);
        setSeat(20);
        setName(name);
    }

    @Override
    void setMode(int isOn) {
        if(isOn == 1){
            this.oiltanksize = this.oiltanksize + 30;
        }
    }

    @Override
    public void printAircon() {
        System.out.println(this.name +": 에어컨 ON" );
    }

    @Override
    public void printAutoDrive() {
        System.out.println(this.name +": 자율주행 ON" );
    }
}
