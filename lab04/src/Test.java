import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] tokens = new String[10];
            tokens = input.split(";");

            for (String token : tokens) {
                if (token == null) {
                    continue;
                }
                System.out.println(token);
            }
        }

    }
}
