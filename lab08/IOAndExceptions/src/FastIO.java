import java.io.*;
import java.util.Arrays;

public class FastIO {

    public static void main(String[] args) {
        try (
//                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//                BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line + " new");
                line = br.readLine();
            }
//            while(true) {
//                try {
//                    String[] tokens = br.readLine().split(";");
//                    bw.write(Arrays.toString(tokens) + "\n");
//                } catch (NullPointerException e) {
//                    break;
//                }
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
