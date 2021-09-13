import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("베르트랑 공준");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        int N = scanner.nextInt();
        int doubleN = N * 2;
        int sqrt = (int) Math.sqrt(doubleN);
        int count = 0;

        boolean[] arr = new boolean[500000];

        for(int i=2; i<arr.length; i++) {
            arr[i] = true;
        }

        for (int i=2; i<=sqrt; i++) {
            if(arr[i] == true) {
                for(int j=i*i; j<=doubleN; j+=i) {
                    arr[j] = false;
                }
            }
        }

        for(int i=2; i<doubleN; i++) {
            if(arr[i] == true && i > N) {
                System.out.print(i + " ");
                count += 1;
            }
        }
        System.out.println();

        System.out.println(N + "보다 크고 " + (N * 2) + "보다 작은 소수는 " + count + "개이다." );

        scanner.close();
    }
}