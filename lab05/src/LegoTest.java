import java.util.Arrays;
import java.util.Scanner;

public class LegoTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Lego[] legos = new Lego[n];

        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(";");

            Lego lego = new Lego(
                    tokens[0],
                    tokens[1],
                    tokens[2],
                    Integer.parseInt(tokens[3]));

            legos[i] = lego;
        }

        Arrays.sort(legos);

        for(Lego lego : legos) {
            System.out.println(lego);
        }

    }
}
