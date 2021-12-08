import java.io.*;
import java.util.Scanner;

public class FileR {
    public static void main(String[] args) throws IOException {
        // ㅍㅏ일 전체를 읽어 화면에 출력하는 코드 샘플
        FileReader fin = new FileReader("c:\\test.txt");
        int c;
        while((c = fin.read()) != -1) {
            System.out.println((char)c);
        }
        fin.close();

        // 텍스트 파일 읽기
        FileReader fin2 = null;
        try {
            fin2 = new FileReader("c:\\windows\\system.ini");
            int c2;
            while ((c2 = fin2.read()) != -1) {
                System.out.println((char) c2);
            }
            fin.close();
        } catch (IOException e) {
            System.out.println("error");
        }

        // inputstream를 통한 텍스트 파일 읽기 한글 읽기
        FileInputStream fin3 = new FileInputStream("c:\\temp\\hangul.txt");
        InputStreamReader in = new InputStreamReader(fin3, "MS949");
        int c3;

        System.out.println(in.getEncoding());
        while((c3 = in.read()) != -1) {
            System.out.println((char) c3);
        }
        in.close();
        fin3.close();

        // FileWriter
        // 문자 단위
        FileWriter fout = new FileWriter("c:\\temp\\test.txt");
        fout.write('A');
        fout.close();

        // 블록 단위
        char[] buf = new char[1024];
        // 처음부터 1024개 다 입력
        fout.write(buf, 0, buf.length);

        // 키보드 입력해서 파일 저장
        Scanner scanner = new Scanner(System.in);
        FileWriter fout2 = null;
        int c4;
        try {
            fout2 = new FileWriter("c:\\temp\\test.txt");
            while(true) {
                String line = scanner.nextLine();
                if(line.length() == 0)
                    break;
                fout2.write(line, 0, line.length());
                fout2.write("\r\n", 0, 2); // 한줄 띄우기
            }
            fout2.close();
        } catch (IOException e) {
            System.out.println("error");
        }
        scanner.close();

        // FileOutputStream 바이너리 파일 쓰기
        byte b[] = {7, 51, 3, 4, -1, 24};
        try {
            FileOutputStream fout3 = new FileOutputStream("c:\\temp\\test.out");
            for(int i=0; i<b.length; i++)
                fout.write(b[i]);
            fout3.close();
        } catch (IOException e) {
            System.out.println("error");
        }

        // FileInputStream 바이너리 파일 읽기
        byte b2[] = new byte[6];
        try {
            FileInputStream fin5 = new FileInputStream("c:\\temp\\test.out");
            int n=0, c5;
            while((c5 = fin5.read()) != -1) {
                b[n] = (byte)c5;
                n++;
            }
            for (int i = 0; i < b2.length; i++) System.out.println(b2[i]);
            fin5.close();
        } catch (IOException e) {
            System.out.println("error");
        }

        // 20byte bufferedoutputstream
        BufferedOutputStream bout = new BufferedOutputStream(System.out, 20);
        FileReader fin6 = new FileReader("c:\\windows\\system.ini");

        int c6;
        while((c6 = fin.read()) != -1) {
            bout.write((char) c);
        }
        fin6.close();
        bout.close();

        // 버퍼 스트림을 이용한 출력
        FileReader fr = null;
        int a;
        try {
            fr = new FileReader("c:\\temp\\test.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while((a = fr.read()) != -1) {
                out.write(a);
            }
            new Scanner(System.in).nextLine(); // 엔터키 기다림
            out.flush(); // 버퍼에 남아있는 문자 모두 출력
            fr.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
