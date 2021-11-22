public class SmartBand {
    private static int count = 1;
    private int id;
    private int limitHeartBeat = 120;
    private Server server;

    SmartBand(Server server) {
        id = count++;
        this.server = server;
    }

    void checkHeartBeat(int heartBeat, String content) {
        System.out.println("현재 심장 박동 " + heartBeat);
        if (heartBeat >= limitHeartBeat) {
            System.out.println("심장 박동이 " + limitHeartBeat + "를 넘어섰습니다." + content + " 상황이 서버에 기록됩니다.");
            sendServer(id, content);
        } else {
            System.out.println(limitHeartBeat + "이하라 기록되지 않습니다.");
        }
    }

    void sendServer(int id, String content) {
        server.save(id, content);
    }

    public int getId() {
        return id;
    }
}
