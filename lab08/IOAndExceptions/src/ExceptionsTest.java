import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsTest {

    public static void main(String[] args) {
        try {
            int[] faultyArray = new int[1];
            System.out.println(faultyArray[10]);
            System.out.println(5 / 0);
            Scanner sc = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Faulty Array");
        } catch (ArithmeticException e) {
            System.out.println("Cannot perform division");
        } finally {
            System.out.println("I am here, whether you like it or not!");
        }
    }

}
