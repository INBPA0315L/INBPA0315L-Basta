import java.util.Arrays;
import java.util.Scanner;

public class Airport implements Comparable<Airport>{

    private String name;
    private String city;
    private int runways;
    private int time;

    public Airport(String name, String city, int runways, int time) {
        this.name = name;
        this.city = city;
        this.runways = runways;
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %d", name, city, time);
    }

    @Override
    public int compareTo(Airport o) {
        if(this.runways != o.runways) {
            // Negative Sign -> Descending
            return -Integer.compare(this.runways, o.runways);
        }
        if(this.time != o.time) {
            return -Integer.compare(this.time, o.time);
        }
        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        Airport[] airports = new Airport[20];

        Scanner sc = new Scanner(System.in);
        int counter = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

//            if(line.equals("END")) {
//                break;
//            }

            String[] tokens = line.split(";");

            Airport airport = new Airport(
                    tokens[0],
                    tokens[1],
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3])
            );
            airports[counter] = airport;
            counter++;
        }

        Arrays.sort(airports, 0, counter);

        for(Airport airport : airports) {
            if (airport == null) {
                continue;
            }
            System.out.println(airport);
        }
    }
}
