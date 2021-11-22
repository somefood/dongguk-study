import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Abuser abuser = new Abuser();
        Server server = new Server();
        Monitor monitor = new Monitor(server);
        Child child = new Child("홍석주", 5, server);
        Parent parent = new Parent(child, server, monitor);

        while (!exit) {
            showMenu();
            int n = scanner.nextInt();
            switch (n) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    abuser.abuse(child);
                    break;
                case 2:
                    child.play();
                    break;
                case 3:
                    child.fight();
                    break;
                case 4:
                    parent.get();
                    break;
                case 5:
                    parent.requestMonitor();
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("1.학대");
        System.out.println("2.놀기");
        System.out.println("3.싸우기");
        System.out.println("4.부모님 알림 조회");
        System.out.println("5.모니터링단에게 요청");
        System.out.println("0. 종료");
        System.out.print("입력> ");
    }
}