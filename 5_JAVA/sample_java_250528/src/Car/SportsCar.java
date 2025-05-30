package Car;

public class SportsCar extends Car implements Audio, AutoDrive {
    public SportsCar(String name) {
        setKmperliter(8);
        setSpeed(250);
        setOiltanksize(30);
        setSeat(2);
        setName(name);
    }

    @Override
    void setMode(int isOn) {
        if (isOn == 1) {
            this.speed *= 1.2;
        }
    }

    @Override
    public void printAudio() {
        System.out.println(this.name + " : 오디오 ON" );
    }

    @Override
    public void printAutoDrive() {
        System.out.println(this.name + " : 자율주행 ON" );
    }

}
