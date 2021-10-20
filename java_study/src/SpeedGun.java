public class SpeedGun {

    private int theSpeed;

    void shot(Car car) {    // 스피드건 -> 차 속도 메시지패싱
        theSpeed = car.current();
    }

    void monitor(Road road) {
        int limit = road.getLimit();
        System.out.print("\t current speed:" + theSpeed + "Km ");
        if (theSpeed > limit) {
            System.out.println("speed limit: " + limit + "Km ticked by " + (theSpeed - limit) + "Km over");
        } else {
            System.out.println("speed limit: " + limit + "Km");
        }
    }
}
