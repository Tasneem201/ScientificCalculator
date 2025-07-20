import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1 -> performAddition(scanner);
                case 2 -> performSubtraction(scanner);
                case 3 -> performMultiplication(scanner);
                case 4 -> performDivision(scanner);
                case 5 -> performSquareRoot(scanner);
                case 6 -> performPower(scanner);
                case 7 -> performSine(scanner);
                case 8 -> performCosine(scanner);
                case 9 -> performTangent(scanner);
                case 10 -> performNaturalLog(scanner);
                case 11 -> performLogBase10(scanner);
                case 12 -> performAbsolute(scanner);
                case 13 -> performRound(scanner);
                case 14 -> performCeil(scanner);
                case 15 -> performFloor(scanner);
                case 16 -> performMin(scanner);
                case 17 -> performMax(scanner);
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    public static void displayMenu() {
        System.out.println("\n--- Scientific Calculator Menu ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine (degrees)");
        System.out.println("8. Cosine (degrees)");
        System.out.println("9. Tangent (degrees)");
        System.out.println("10. Natural Logarithm (ln)");
        System.out.println("11. Logarithm Base 10 (log10)");
        System.out.println("12. Absolute Value");
        System.out.println("13. Round");
        System.out.println("14. Ceiling");
        System.out.println("15. Floor");
        System.out.println("16. Minimum of two numbers");
        System.out.println("17. Maximum of two numbers");
        System.out.println("0. Exit");
    }

    // --- Math Logic Methods ---

    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) { return a / b; }
    public static double calculateSquareRoot(double a) { return Math.sqrt(a); }
    public static double calculatePower(double base, double exponent) { return Math.pow(base, exponent); }
    public static double calculateSine(double degrees) { return Math.sin(Math.toRadians(degrees)); }
    public static double calculateCosine(double degrees) { return Math.cos(Math.toRadians(degrees)); }
    public static double calculateTangent(double degrees) { return Math.tan(Math.toRadians(degrees)); }
    public static double calculateNaturalLogarithm(double a) { return Math.log(a); }
    public static double calculateLog10(double a) { return Math.log10(a); }
    public static double calculateAbsolute(double a) { return Math.abs(a); }
    public static long roundNumber(double a) { return Math.round(a); }
    public static double ceilingNumber(double a) { return Math.ceil(a); }
    public static double floorNumber(double a) { return Math.floor(a); }
    public static double findMin(double a, double b) { return Math.min(a, b); }
    public static double findMax(double a, double b) { return Math.max(a, b); }

    // --- Input/Output Methods ---

    private static void performAddition(Scanner s) { twoInputs(s, "Addition", ScientificCalculator::add); }
    private static void performSubtraction(Scanner s) { twoInputs(s, "Subtraction", ScientificCalculator::subtract); }
    private static void performMultiplication(Scanner s) { twoInputs(s, "Multiplication", ScientificCalculator::multiply); }
    private static void performDivision(Scanner s) {
        try {
            System.out.print("Enter numerator: ");
            double a = s.nextDouble();
            System.out.print("Enter denominator: ");
            double b = s.nextDouble();
            if (b == 0) {
                System.out.println("Error: Cannot divide by zero.");
            } else {
                System.out.println("Result: " + divide(a, b));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            s.next();
        }
    }

    private static void performSquareRoot(Scanner s) {
        try {
            System.out.print("Enter a number: ");
            double a = s.nextDouble();
            if (a < 0) {
                System.out.println("Error: Negative input for square root.");
                return;
            }
            System.out.println("Result: " + calculateSquareRoot(a));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            s.next();
        }
    }

    private static void performPower(Scanner s) { twoInputs(s, "Power", ScientificCalculator::calculatePower); }
    private static void performSine(Scanner s) { oneInput(s, "Sine", ScientificCalculator::calculateSine); }
    private static void performCosine(Scanner s) { oneInput(s, "Cosine", ScientificCalculator::calculateCosine); }
    private static void performTangent(Scanner s) { oneInput(s, "Tangent", ScientificCalculator::calculateTangent); }
    private static void performNaturalLog(Scanner s) {
        try {
            System.out.print("Enter number: ");
            double a = s.nextDouble();
            if (a <= 0) {
                System.out.println("Error: ln(x) only defined for x > 0.");
                return;
            }
            System.out.println("Result: " + calculateNaturalLogarithm(a));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            s.next();
        }
    }
    private static void performLogBase10(Scanner s) {
        try {
            System.out.print("Enter number: ");
            double a = s.nextDouble();
            if (a <= 0) {
                System.out.println("Error: log10(x) only defined for x > 0.");
                return;
            }
            System.out.println("Result: " + calculateLog10(a));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            s.next();
        }
    }
    private static void performAbsolute(Scanner s) { oneInput(s, "Absolute", ScientificCalculator::calculateAbsolute); }
    private static void performRound(Scanner s) {
        try {
            System.out.print("Enter number: ");
            double a = s.nextDouble();
            System.out.println("Result: " + roundNumber(a));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            s.next();
        }
    }
    private static void performCeil(Scanner s) { oneInput(s, "Ceiling", ScientificCalculator::ceilingNumber); }
    private static void performFloor(Scanner s) { oneInput(s, "Floor", ScientificCalculator::floorNumber); }
    private static void performMin(Scanner s) { twoInputs(s, "Min", ScientificCalculator::findMin); }
    private static void performMax(Scanner s) { twoInputs(s, "Max", ScientificCalculator::findMax); }

    // --- Functional Interfaces ---
    @FunctionalInterface interface TwoDoubleOp { double apply(double a, double b); }
    @FunctionalInterface interface OneDoubleOp { double apply(double a); }

    private static void twoInputs(Scanner s, String name, TwoDoubleOp op) {
        try {
            System.out.print("Enter first number: ");
            double a = s.nextDouble();
            System.out.print("Enter second number: ");
            double b = s.nextDouble();
            System.out.println(name + " Result: " + op.apply(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            s.next();
        }
    }

    private static void oneInput(Scanner s, String name, OneDoubleOp op) {
        try {
            System.out.print("Enter number: ");
            double a = s.nextDouble();
            System.out.println(name + " Result: " + op.apply(a));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            s.next();
        }
    }
}

