import java.util.Objects;

public class Car implements Moving{

    private String plate;
    private int power;
    private boolean automatic;

    public static int numberOfCars;

    public static final int WHEELS = 4;

    public Car(String plate, int power, boolean automatic) {
        this.plate = plate;
        this.power = power;
        this.automatic = automatic;
        numberOfCars++;
    }

    public Car(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", power=" + power +
                ", automatic=" + automatic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(plate, car.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate);
    }

    public static Car getCoolerCar(Car c1, Car c2) {
        if(c1.power > c2.power) {
            return c1;
        } else {
            return c2;
        }
    }

    @Override
    public void move() {
        System.out.println("Vroom Vroom");
    }

    @Override
    public void repair() {
        System.out.println("I am being repaired.");
    }
}
