import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("두수의 최대공약수");

        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();

        int gcd = 1;
        for(int i=2; i<=N; i++) {
            while(M%i==0 && N%i==0) {
                gcd*=i;
                M = M/i;
                N = N/i;
            }
        }
        System.out.println(gcd);
    }
}