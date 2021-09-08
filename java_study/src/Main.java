import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("에라토스테네스 체 소수 판별법");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        int N = scanner.nextInt();
        int sqrt = (int) Math.sqrt(N);

        boolean[] arr = new boolean[200];

        for(int i=2; i<arr.length; i++) {
            arr[i] = true;
        }

        for (int i=2; i<=sqrt; i++) {
            if(arr[i] == true) {
                for(int j=i*i; j<=N; j+=i) {
                    arr[j] = false;
                }
            }
        }

        for(int i=2; i<N; i++) {
            if(arr[i] == true) System.out.print(i + " ");
        }
//
//        for (int i=4; i<arr.length; i+=2) {
//            arr[i] = false;
//        }
//
//        for(int i=3; i<arr.length; i+=2) {
//            for(int j=i+i; j<sqrt; j+=i) {
//                arr[j] = false;
//            }
//        }

        scanner.close();
    }
}