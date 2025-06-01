import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first no");
        int numberOne = sc.nextInt();
        System.out.println("Enter second no");
        int  numberTwo = sc.nextInt();
        boolean isContinue = true;
        Helper obj1 = new Helper(numberOne, numberTwo);
        while(isContinue) {
            isContinue = obj1.operate();
        }
    }
}
