import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("냉장고 코드");

        Scanner sc = new Scanner(System.in);
        int i;
        short flag = 0b000000000000;

        while (true) {
            System.out.print("> ");
            i = sc.nextInt();
            if(i == 13) {
                System.out.println("종료");
                break;
            }
            flag = (short) (flag | (1 << (i-1)));
            System.out.println(Integer.toHexString(flag));
        }
        sc.close();
    }
}