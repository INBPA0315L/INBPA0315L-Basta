import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            while(sc.hasNextLine()) {
                String[] tokens = sc.nextLine().split(";");
                System.out.println(Arrays.toString(tokens));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

}
