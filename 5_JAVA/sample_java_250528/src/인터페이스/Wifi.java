package 인터페이스;

public class Wifi implements NetworkAdaptar {
    String company;
    public Wifi(String name) {
        this.company = name;
    }

    @Override
    public void connect() {
        System.out.println(company + "WiFi에 연결되었습니다.");
    }
}

class FiveG implements NetworkAdaptar {
    String company;
    public FiveG(String name) {
        this.company = name;
    }

    @Override
    public void connect() {
        System.out.println(company + "5G에 연결되었습니다.");
    }
}
class LTE implements NetworkAdaptar {
    String company;
    public LTE(String name) {
        this.company = name;
    }

    @Override
    public void connect() {
        System.out.println(company + "LTE에 연결되었습니다.");
    }
}


