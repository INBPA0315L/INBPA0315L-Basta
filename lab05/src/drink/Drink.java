package drink;

import java.util.Objects;

public class Drink implements Comparable<Drink>{

    public String name;
    protected String unit;
    private int price;

    public Drink() {
    }

    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
        this.unit = "5 dl";
    }

    public Drink(String name, String unit, int price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + unit + ", " + price + " Ft";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return price == drink.price && Objects.equals(name, drink.name) && Objects.equals(unit, drink.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit, price);
    }

    @Override
    public int compareTo(Drink o) {
        if(this.price != o.price) {
            return -Integer.compare(this.price, o.price);
        }
        if(!this.unit.equals(o.unit)) {
            return this.unit.compareTo(o.unit);
        }
        return this.name.compareTo(o.name);
    }
}
