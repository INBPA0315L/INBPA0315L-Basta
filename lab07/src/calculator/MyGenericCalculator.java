package calculator;

public class MyGenericCalculator
        implements GenericCalculator<Integer> {

    @Override
    public Integer add(Integer left, Integer right) {
        return left + right;
    }

    @Override
    public Integer multiply(Integer left, Integer right) {
        return left * right;
    }

    public static void main(String[] args) {
        GenericCalculator<Integer> calculator = new MyGenericCalculator();
        System.out.println(calculator.multiply(2, 3));
        System.out.println(calculator.add(2, 3));
    }
}
