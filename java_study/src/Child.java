import java.util.Random;

public class Child {
    private String name;
    private int age;
    private int heartBeat = 100;
    private Random random = new Random();
    private SmartBand smartBand;

    public Child(String name, int age, Server server) {
        this.name = name;
        this.age = age;
        this.smartBand = new SmartBand(server);
    }

    public void setHeartBeat(int heartBeat, String content) {
        smartBand.checkHeartBeat(this.heartBeat + heartBeat, content);
    }

    public SmartBand getSmartBand() {
        return smartBand;
    }

    public void play() {
        System.out.println(name + "(이)가 놉니다.");
        int n = random.nextInt(30);
        smartBand.checkHeartBeat(this.heartBeat + n, "play");
    }

    public void fight() {
        System.out.println(name + "(이)가 싸웁니다.");
        int n = random.nextInt(30);
        smartBand.checkHeartBeat(this.heartBeat + n, "fight");
    }
}
