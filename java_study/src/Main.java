import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // 1-1
        System.out.print("설정값 입력>");
        int a = scan.nextInt();
        System.out.printf("0x%08x\n", a);


        // 1-2
        int flag = a;
        System.out.print("설정할 비트 위치 (32~1)>");
        int b = scan.nextInt();
        flag = flag | (1 << (b-1));
        System.out.printf("0x%08x\n", flag);

        // 2-1

        System.out.print("2차원 배열 가로, 세로 입력>");
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] array = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                array[i][j] = random.nextInt(89) + 10;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // 2-2
        int[][] array2 = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                array2[i][j] = array[m-1-j][i];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        // 3-1
        Leaf leaf = new Leaf(250);
        leaf.show();

        // 3-2
        Plants basil = new Plants(20, 300);
        basil.show();
    }
}

class Leaf {
    private int solar;

    Leaf(int solar) {
        this.solar = solar;
    }

    void show() {
        System.out.println("태양 빛: " + solar +"분");
    }
}

class Plants {
    private int water;
    Leaf leaf;

    Plants(int water, int solar) {
        this.water = water;
        leaf = new Leaf(solar);
    }

    void show() {
        System.out.print("물: " + water + "l, ");
        leaf.show();
    }
}