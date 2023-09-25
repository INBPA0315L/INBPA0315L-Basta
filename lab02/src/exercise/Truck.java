package exercise;

public class Truck extends Car{

    protected int capacity;

    public Truck(String plate, int power, boolean automatic, int capacity) {
        super(plate, power, automatic);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "plate='" + super.getPlate() + '\'' +
                ", power=" + super.getPower() +
                ", automatic=" + super.isAutomatic() +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        Truck t1 = new Truck("LRA65", 80, true, 50);

        System.out.println(t1);
    }
}
