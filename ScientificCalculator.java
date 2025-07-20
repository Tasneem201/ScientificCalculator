import java.util.Scanner;
import java.util.InputMismatchException;

public class ScientificCalculator {

//Task3

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("\nEnter your choice: ");
            int choice = -1;

            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: performAddition(scanner); break;
                    case 2: performSubtraction(scanner); break;
                    case 3: performMultiplication(scanner); break;
                    case 4: performDivision(scanner); break;
                    case 5: performSquareRoot(scanner); break;
                    case 6: performPower(scanner); break;
                    case 7: performSine(scanner); break;
                    case 8: performCosine(scanner); break;
                    case 9: performTangent(scanner); break;
                    case 10: performNaturalLog(scanner); break;
                    case 11: performLogBase10(scanner); break;
                    case 12: performAbsolute(scanner); break;
                    case 13: performRounding(scanner); break;
                    case 14: performCeiling(scanner); break;
                    case 15: performFloor(scanner); break;
                    case 16: performMin(scanner); break;
                    case 17: performMax(scanner); break;
                    case 0:
                        exit = true;
                        System.out.println("Exiting calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n=== Scientific Calculator Menu ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine");
        System.out.println("8. Cosine");
        System.out.println("9. Tangent");
        System.out.println("10. Natural Logarithm (ln x)");
        System.out.println("11. Logarithm Base 10 (log₁₀ x)");
        System.out.println("12. Absolute Value");
        System.out.println("13. Round");
        System.out.println("14. Ceiling");
        System.out.println("15. Floor");
        System.out.println("16. Minimum of two numbers");
        System.out.println("17. Maximum of two numbers");
        System.out.println("0. Exit");
    }

    // Arithmetic operations
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    // Scientific operations
    public static double calculateSquareRoot(double a) {
        if (a < 0) throw new IllegalArgumentException("Cannot take square root of negative number");
        return Math.sqrt(a);
    }
    public static double calculatePower(double base, double exp) { return Math.pow(base, exp); }
    public static double calculateSine(double degrees) { return Math.sin(Math.toRadians(degrees)); }
    public static double calculateCosine(double degrees) { return Math.cos(Math.toRadians(degrees)); }
    public static double calculateTangent(double degrees) { return Math.tan(Math.toRadians(degrees)); }
    public static double calculateNaturalLog(double a) {
        if (a <= 0) throw new IllegalArgumentException("Logarithm undefined for non-positive numbers");
        return Math.log(a);
    }
    public static double calculateLogBase10(double a) {
        if (a <= 0) throw new IllegalArgumentException("Logarithm undefined for non-positive numbers");
        return Math.log10(a);
    }
    public static double calculateAbsolute(double a) { return Math.abs(a); }
    public static long roundNumber(double a) { return Math.round(a); }
    public static double ceilingNumber(double a) { return Math.ceil(a); }
    public static double floorNumber(double a) { return Math.floor(a); }
    public static double findMin(double a, double b) { return Math.min(a, b); }
    public static double findMax(double a, double b) { return Math.max(a, b); }

    // --- Interaction Handlers ---
    private static void performAddition(Scanner scanner) {
        double[] nums = promptTwoNumbers(scanner);
        System.out.println("Result: " + add(nums[0], nums[1]));
    }
    private static void performSubtraction(Scanner scanner) {
        double[] nums = promptTwoNumbers(scanner);
        System.out.println("Result: " + subtract(nums[0], nums[1]));
    }
    private static void performMultiplication(Scanner scanner) {
        double[] nums = promptTwoNumbers(scanner);
        System.out.println("Result: " + multiply(nums[0], nums[1]));
    }
    private static void performDivision(Scanner scanner) {
        double[] nums = promptTwoNumbers(scanner);
        try {
            System.out.println("Result: " + divide(nums[0], nums[1]));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void performSquareRoot(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        try {
            System.out.println("Result: " + calculateSquareRoot(num));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void performPower(Scanner scanner) {
        double[] nums = promptTwoNumbers(scanner);
        System.out.println("Result: " + calculatePower(nums[0], nums[1]));
    }
    private static void performSine(Scanner scanner) {
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        System.out.println("Result: " + calculateSine(angle));
    }
    private static void performCosine(Scanner scanner) {
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        System.out.println("Result: " + calculateCosine(angle));
    }
    private static void performTangent(Scanner scanner) {
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        System.out.println("Result: " + calculateTangent(angle));
    }
    private static void performNaturalLog(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        try {
            System.out.println("Result: " + calculateNaturalLog(num));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void performLogBase10(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        try {
            System.out.println("Result: " + calculateLogBase10(num));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void performAbsolute(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        System.out.println("Result: " + calculateAbsolute(num));
    }
    private static void performRounding(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        System.out.println("Result: " + roundNumber(num));
    }
    private static void performCeiling(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        System.out.println("Result: " + ceilingNumber(num));
    }
    private static void performFloor(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        System.out.println("Result: " + floorNumber(num));
    }
    private static void performMin(Scanner scanner) {
        double[] nums = promptTwoNumbers(scanner);
        System.out.println("Result: " + findMin(nums[0], nums[1]));
    }
    private static void performMax(Scanner scanner) {
        double[] nums = promptTwoNumbers(scanner);
        System.out.println("Result: " + findMax(nums[0], nums[1]));
    }

    private static double[] promptTwoNumbers(Scanner scanner) {
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        return new double[]{a, b};
    }
}

