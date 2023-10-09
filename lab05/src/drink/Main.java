package drink;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // use inputs from input.txt
        Scanner sc = new Scanner(System.in);
        Drink[] drinks = new Drink[20];
        int counter = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(";");

            if (tokens.length == 3) {
                Drink drink = new Drink(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]));
                drinks[counter] = drink;
            }
            else {
                Alcoholic alcoholic = new Alcoholic(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Double.parseDouble(tokens[3])
                );
                drinks[counter] = alcoholic;
            }

            counter++;
        }

        Arrays.sort(drinks, 0, counter);

        for(Drink drink : drinks) {
            if(drink == null) {
                break;
            }
            System.out.println(drink);
        }
    }
}
