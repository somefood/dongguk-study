public class Road {
    private int limit;
    Road() {
        int a = (int)(Math.random() * 4) + 1;
        switch (a) {
            case 1:
                limit = 60;
                break;
            case 2:
                limit = 70;
                break;
            case 3:
                limit = 80;
            case 4:
                limit = 90;
                break;
        }
    }

    int getLimit() {
        return limit;
    }
}
