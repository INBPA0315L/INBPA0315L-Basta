public class TruckTest {

    public static void main(String[] args) {

        Truck t1 = new Truck("OOP66", 80, false, 100);
        Car ferrari = new Car("CLI5145", 100, true);

        System.out.println(t1);
        System.out.println(ferrari);
        t1.move();
        t1.repair();
    }
}
