package name;
@FunctionalInterface
interface SquareCalculator {
    int calculateSquare(int number);
    default void printMessage(int number) {
        int square = calculateSquare(number);
        System.out.println("The square of " + number + " is: " + square);
    }
}
public class CustomFunctionalInterfaceProblem {
    public static void main(String[] args) {
        SquareCalculator squareCalculator = (number) -> number * number;
        squareCalculator.printMessage(5);
        squareCalculator.printMessage(10);
    }
}

