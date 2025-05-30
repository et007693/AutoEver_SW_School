//package 인터페이스2;
//
//import java.util.Scanner;
//
//public class CocoaMain {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        NetworkAdapter adapter;
//        System.out.print("네트워크 선택 [1]WiFi [2]5G : ");
//        int choice = sc.nextInt();
//        adapter = (choice == 1) ? new WiFi() : new FiveG();
//
//        CocoaTalk cocoaTalk = new CocoaTalk("IVE", adapter);
//        cocoaTalk.writeMsg("오늘은 덥네요. 건강 조심하세요~~");
//        cocoaTalk.send();
//
//    }
////    private String to;
////    private String msg;
////    private NetworkAdapter adaptar;
////
////    public CocoaTalk(String to, NetworkAdaptar adaptar) {
////        this.to = to;
////        this.adaptar = adaptar;
////    }
//}
