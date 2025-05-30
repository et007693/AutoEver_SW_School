package 디폴트메소드;
// 필드 : 모든 필드는 자동으로 final static으로 변환

public interface RemoteControl {
    int MAX_VOLUME = 100; // 인터페이스 생성 시 한번 생성되고 변경 불가
    int MIN_VOLUME = 0;
    void turnON(); // abstract 자동으로 추가
    void turnOFF();
    void setVolume(int vol);
    // 디폴트 메서드 : 구현부가 있으면 구현 여부는 선택 사항이 됨
    default  void setMute(boolean mute) {
        if (mute) System.out.println("무음처리 합니다.");
        else System.out.println("무음해제 합니다.");
    }
    static void changeBattery() {
        System.out.println("건전지를 교환합니다.");
    }

}
