import java.util.Random;

public class Abuser {

    Random strength = new Random();

    void abuse(Child child) {
        System.out.println("학대범이 아이를 학대합니다.");
        child.setHeartBeat(20 + strength.nextInt(10), "abuse");
    }
}
