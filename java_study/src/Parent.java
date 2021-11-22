import java.util.ArrayList;
import java.util.Scanner;

public class Parent {
    private Child myChild;
    private Server server;
    private Monitor monitor;
    private int childId;;
    Scanner scanner = new Scanner(System.in);

    public Parent(Child child, Server server, Monitor monitor) {
        this.myChild = child;
        this.server = server;
        this.monitor = monitor;
        childId = myChild.getSmartBand().getId();
    }

    void get() {
        ArrayList<String> situations = server.getSituations(childId);
        int n = 1;
        for (String situation : situations) {
            System.out.println(n + ": " + situation);
            n++;
        }
    }

    void requestMonitor() {
        System.out.println("어느 영상을 요청하겠습니까");
        get();
        System.out.print("입력> ");
        int n = scanner.nextInt();
        String record = monitor.get(childId, n);
        System.out.println("모니터링단에게 요청받은 " + record + "내용을 확인합니다.");
    }
}
