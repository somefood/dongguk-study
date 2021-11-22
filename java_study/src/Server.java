import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    private HashMap<Integer, ArrayList<String>> dic = new HashMap<>();

    void save(int id, String situation) {
        ArrayList<String> list = new ArrayList<>();
        if (dic.containsKey(id)) {
            list = dic.get(id);
            list.add(situation + ".mp4");
        } else {
            list.add(situation + ".mp4");
        }
        dic.put(id, list);
        System.out.println("녹음을 저장하고 부모님에게 알람을 보냅니다.");
    }

    ArrayList<String> getSituations(int id) {
        return dic.get(id);
    }

    String getSituation(int id, int n) {
        ArrayList<String> situations = dic.get(id);
        return situations.get(n);
    }
}
