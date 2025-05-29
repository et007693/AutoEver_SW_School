package 접근제한자;

public class Parent {
    String name;
    protected String money;
    String addr;

    public Parent() {
        name = "이건희";
        money = "100억";
        addr = "서울시 강남구 삼성동";
    }

    public String getName() {
        return name;
    }
}
