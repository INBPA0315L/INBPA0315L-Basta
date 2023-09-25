package classwork;

import java.util.Objects;

public class CarTest {

    public static void main(String[] args) {
        Car ferrari = new Car("Ferrari", "Laferrari", "Red");
        Car tobi = new Car("Lexus", "L5", "Black");

        System.out.println("Ferrari:");
        ferrari.accelerate(50);
//        System.out.println(ferrari.color);
//        ferrari.setColor("Green");
//        System.out.println(ferrari.getColor());

        System.out.println("Tobi:");
        tobi.honk();
        System.out.println(tobi.getType());
        System.out.println(tobi.getModel());

        System.out.println("--------------------------");

        System.out.println(ferrari);

        Car focus = new Car("Ford", "Focus", "red");
        Car focus2 = new Car("Ford", "Focus", "red");

        System.out.println(focus.equals(focus2));
        System.out.println(focus2.equals(focus));
        System.out.println(Objects.equals(focus, focus2));

        System.out.println(focus.hashCode());
        System.out.println(focus2.hashCode());
    }
}
