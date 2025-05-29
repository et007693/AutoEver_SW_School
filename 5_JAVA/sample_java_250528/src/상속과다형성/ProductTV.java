package 상속과다형성;

public class ProductTV extends Prototype {
    String name;
    boolean isInternet;

    public ProductTV(boolean isPower, int cnl, int vol, boolean isInternet) {
        super(isPower, cnl, vol);
        this.isInternet = isInternet;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setVolume(int vol) {
        if (vol >= 0 && vol <= 100){
            volume = vol;
            System.out.println("볼륨을 " + volume + " 으로 변경하였습니다.");
        } else {
            System.out.println("볼륨 설정 범위가 아닙니다.");
        }
        this.volume = vol;
    }

    @Override // 오버라이딩 관계 성립 여부를 문법적으로 체크해주는 어노테이션
    public void setChannel(int cnl) {
        if(cnl > 0 && cnl < 2000) {
            System.out.println("채널을 " + channel + " 으로 변경하였습니다.");
            channel = cnl;
        } else {
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }

    // 메소드 오버로딩 : 매개변수의 갯수와 타입으로 구분하는 것
    public void setChannel (int cnl, boolean isIntenet) {
        if (isIntenet) {
            System.out.println("인터넷 모드입니다.");
            this.isInternet = true;
        } else {
            this.isInternet = false;
            if(cnl > 0 && cnl < 2000) {
                System.out.println("채널을 " + channel + " 으로 변경하였습니다.");
                channel = cnl;
            } else {
                System.out.println("채널 설정 범위가 아닙니다.");
            }
        }
    }

    void viewTV() {
        System.out.println("이름 : " + name);
        System.out.println("전원 : " + isPower);
        System.out.println("채널 : " + channel);
        System.out.println("볼륨 : " + volume);
        System.out.println("인터넷 모드 : " + isInternet);
    }
}
