package Car;

abstract public class Car {
    double speed;
    int kmperliter;
    int oiltanksize;
    double consume;
    int movecount;
    int distance;
    int oilcount;
    int price;
    double time;
    int seat;
    int weather;

    String name;

    public void setOiltanksize(int oiltanksize) {
        this.oiltanksize = oiltanksize;
    }

    public void setConsume() {
        this.consume = (double) this.distance / this.kmperliter;
    }

    public void setKmperliter(int kmperliter) {
        this.kmperliter = kmperliter;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMovecount(int passenger) {
        this.movecount = (int) Math.ceil((double) passenger / this.seat);
    }

    public void setDistance(int num) {
        int[] arr = {400, 150, 200, 300};
        this.distance = arr[num - 1] * this.movecount;
    }

    public void setOilcount() {
        this.oilcount = (int) Math.ceil(this.consume / this.oiltanksize);
    }

    public void setPrice() {
        this.price = (int)(this.consume * 2000);
    }

    public void setTime() {
        double[] num = {1.0, 1.2, 1.4};
        this.time = (double) this.distance / this.speed * num[this.weather - 1];
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    abstract void setMode(int isOn);

    public void printResult() {
        int hour = (int) this.time;
        int minute = (int) ((this.time - hour) * 60);
        System.out.println("=======" + this.name + "=======");
        System.out.println("총 비용 : " + this.price);
        System.out.println("총 주유 횟수 : " + this.oilcount);
        System.out.println("총 이동 시간 : " + hour + "시간 " + minute + "분");
    }
}
