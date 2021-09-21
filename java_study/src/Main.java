import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int gcd(List<Integer> list) {

        while (list.size() >= 2) {
            int gcd = 1;
            int N = list.get(0);
            int M = list.get(1);
            for(int i=2; i<=N; i++) {
                while(M%i==0 && N%i==0) {
                    gcd*=i;
                    M = M/i;
                    N = N/i;
                }
            }
            list.remove(0); list.remove(0);
            list.add(gcd);
        }
        return list.get(0);
    }

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
//        System.out.print("> ");
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String[] line = bf.readLine().split(" ");
//
//        for (String s : line) {
//            list.add(Integer.parseInt(s));
//        }
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println(gcd(list));

    }
}