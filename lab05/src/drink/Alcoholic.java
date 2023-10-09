package drink;

public class Alcoholic extends Drink {

    private double alcoholContent;

    public Alcoholic(String name, String unit, int price, double alcoholContent) {
        super(name, unit, price);
        this.alcoholContent = alcoholContent;
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(double alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    @Override
    public String toString() {
        return alcoholContent + "% V/V " + super.toString();
    }
}
