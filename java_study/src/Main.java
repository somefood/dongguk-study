import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("난수 개수>");
        n = scanner.nextInt();
        writeFile();
        readFile();
    }

    public static void writeFile() throws IOException {
        FileOutputStream fout = new FileOutputStream("test.out");
        Random random = new Random();
        byte[] b = new byte[n];
        for(int i=0; i<n; i++) {
            b[i] = (byte)(random.nextInt(90) + 10);
            for (int j=0; j<i; j++) {
                if(b[i] == b[j]) {
                    i--;
                    break;
                }
            }

            System.out.print(b[i] + " ");
            fout.write(b[i]);
        }
        System.out.println();
        System.out.println("파일 저장 완료");
        fout.close();
    }

    public static void readFile() throws IOException {
        System.out.println("읽기 시작");
        byte[] b = new byte[n];
        FileInputStream fin = new FileInputStream("test.out");
        int a=0, c;
        while((c = fin.read()) != -1) {
            b[a] = (byte)c;
            a++;
        }
        for(int i=0; i<b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.println("읽기 완료");
        fin.close();
    }
}