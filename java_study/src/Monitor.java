public class Monitor {
    private Server server;

    public Monitor(Server server) {
        this.server = server;
    }

    String get(int id, int n) {
        return server.getSituation(id, (n - 1));
    }
}
