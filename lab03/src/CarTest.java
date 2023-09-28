public class CarTest {

    public static void main(String[] args) {

        Car ford = new Car("LA255", 100, true);
        Car toyota = new Car("PLA255", 50, false);
        Car ferrari = new Car("LBA5445");

        System.out.println(ford);
        System.out.println(toyota);

        System.out.println("Ford Plate: " + ford.getPlate());
        System.out.println("The Cooler Car: " + Car.getCoolerCar(ford, toyota));

        System.out.println("Number of Wheels: " + Car.WHEELS);

        System.out.println(ferrari);

        ford.move();
        ford.repair();

    }

}
