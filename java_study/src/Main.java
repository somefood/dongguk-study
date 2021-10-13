import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        String[][] dict = new String[10][2];

        dict[0][0] = "planet";
        dict[0][1] = "행성";

        dict[1][0] = "alchemist";
        dict[1][1] = "연금술사";

        dict[2][0] = "industry";
        dict[2][1] = "산업";

        dict[3][0] = "apple";
        dict[3][1] = "사과";

        dict[4][0] = "banana";
        dict[4][1] = "바나나";

        dict[5][0] = "conduct";
        dict[5][1] = "수행하다";

        dict[6][0] = "search";
        dict[6][1] = "찾다";

        dict[7][0] = "space";
        dict[7][1] = "우주";

        dict[8][0] = "plant";
        dict[8][1] = "식물";

        dict[9][0] = "transform";
        dict[9][1] = "변화";

        for (String[] strings : dict) {
            System.out.println(strings[0] + " " + strings[1]);
        }

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int randomValue = random.nextInt(10);
            System.out.print(dict[randomValue][1] + " > ");
            String value = scanner.next();
            if (dict[randomValue][0].equals(value)) {
                System.out.println("YES");
                count++;
            }
            else {
                System.out.println("NO");
                count--;
            }

            if (count == 3) {
                System.out.println("PASS");
                break;
            } else if (count == -3) {
                System.out.println("FAIL");
                break;
            }
        }
    }
}