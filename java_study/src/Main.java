public class Main {
    public static void main(String[] args) {
        System.out.println("스피드건 모의 실험");
        Car sonata = new Car();
        System.out.println("최고속도: " + sonata.getHighest() + "Km");

        int n = sonata.Navi.find();
        sonata.Navi.monitor();

        for(int i=1; i<=n; i++) { // 목적지까지 각각의 도로와 스피드건을 지나간다.
            // 도로 생성
            Road road = new Road();
            // 스피드건 생성
            SpeedGun speedGun = new SpeedGun();

            System.out.print("도로명" + i);

            // 스피드건 -> 차의 속도 : 메시지패싱
            speedGun.shot(sonata);
            // 스피드건 -> monitor() : 메시지패싱
            speedGun.monitor(road);
        }

    }
}