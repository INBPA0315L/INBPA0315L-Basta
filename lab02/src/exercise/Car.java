package exercise;

import java.util.Objects;

public class Car {
    private String plate;
    private int power;
    private boolean automatic;

    public Car(String plate, int power, boolean automatic) {
        this.plate = plate;
        this.power = power;
        this.automatic = automatic;
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

    public static void main(String[] args) {
        Car alpha = new Car("LPA55", 10, true);
        Car beta = new Car("BO89", 15, true);
        Car gamma = new Car("LPA55", 5, false);

        System.out.println(alpha);
        System.out.println(beta);
        System.out.println(gamma);

        System.out.println("Is alpha equal to beta? " + alpha.equals(beta));
        System.out.println("Is alpha equal to gamma? " + alpha.equals(gamma));
    }
}
