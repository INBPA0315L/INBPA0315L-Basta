import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(new File("input.txt"))
        ) {
            while(sc.hasNextLine()) {
                String[] tokens = sc.nextLine().split(";");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
