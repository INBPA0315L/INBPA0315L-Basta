package lego.v7;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<LegoSet> legoSets = new ArrayList<>();
        while (scanner.hasNextLine()) {
            LegoSet legoSet = new LegoSet(scanner.nextLine());
            legoSets.add(legoSet);
        }

        for (int i = 0; i < legoSets.size(); i++) {
            System.out.println(legoSets.get(i));
        }

        System.out.println("======");

        Collections.sort(legoSets);

        for (LegoSet legoSet : legoSets) {
            System.out.println(legoSet);
        }

        System.out.println("======");

        Collections.sort(legoSets, Comparator.comparing(LegoSet::getTheme));

        for (LegoSet legoSet : legoSets) {
            System.out.println(legoSet);
        }
    }
}
