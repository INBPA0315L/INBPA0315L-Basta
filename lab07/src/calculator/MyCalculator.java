package calculator;

public class MyCalculator
    implements Calculator {


    @Override
    public int add(int left, int right) {
        return left + right;
    }

    @Override
    public int multiply(int left, int right) {
        return left * right;
    }

    public static void main(String[] args) {
        Calculator calculator = new MyCalculator();
        System.out.println(calculator.multiply(2, 3));
        System.out.println(calculator.add(2, 3));
    }
}
