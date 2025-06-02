package Generic;

public class Powder {
    public void doPrinting() {
        System.out.println("Powder 제료로 출력합니다.");
    }

    @Override
    public String toString() {
        return "재료는 Powder입니다.";
    }
}

class Plastic extends Powder {
    public void doPrinting() {
        System.out.println("Plasitc 재료로 출력합니다.");
    }

    @Override
    public String toString() {
        return "재료는 Plastic입니다.";
    }
}

class Water extends Powder {
    public void doPrinting() {
        System.out.println("Water 재료로 출력합니다.");
    }

    @Override
    public String toString() {
        return "재료는 Water입니다.";
    }
}