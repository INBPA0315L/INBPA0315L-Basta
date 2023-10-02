import java.util.Arrays;
import java.util.Scanner;

public class Rollercoaster implements Comparable<Rollercoaster>{

    private String name;
    private String world;
    private int height;
    private int time;

    public Rollercoaster(String name, String world, int height, int time) {
        this.name = name;
        this.world = world;
        this.height = height;
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %d", name, world, time);
    }

    @Override
    public int compareTo(Rollercoaster o) {
        if(this.time != o.time) {
            return Integer.compare(this.time, o.time);
        }
        if(this.height != o.height) {
            return -Integer.compare(this.height, o.height);
        }
        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        Rollercoaster[] rollercoasters = new Rollercoaster[20];

        Scanner sc = new Scanner(System.in);
        int counter = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < counter; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(";");
            Rollercoaster rollercoaster = new Rollercoaster(
                    tokens[0],
                    tokens[1],
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3])
            );
            rollercoasters[i] = rollercoaster;
        }

        Arrays.sort(rollercoasters, 0, counter);

        for (Rollercoaster rollercoaster : rollercoasters) {
            if(rollercoaster == null) {
                continue;
            }
            System.out.println(rollercoaster);
        }
    }
}
