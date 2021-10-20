public class Car {
    private int highest;
    Navigator Navi;

    Car() {
        highest = 140 + 10 * (int) (Math.random() * 8);
        Navi = new Navigator();
    }

    int current() {
        return (int) (Math.random() * highest + 1);
    }

    int getHighest() {
        return highest;
    }
}
