import java.util.Scanner;
public class Calculator {



    //task 1
        public static void main(String[] args) {
            Scanner inputReader = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = inputReader.nextLine();

            System.out.print("Enter your age: ");
            int age = inputReader.nextInt();

            System.out.print("Enter your height in meters: ");
            double height = inputReader.nextDouble();

            System.out.println("\nHello, " + name + "!");
            System.out.println("You are " + age + " years old.");
            System.out.println("And you are " + height + " meters tall.");

            inputReader.close();
        }



}


