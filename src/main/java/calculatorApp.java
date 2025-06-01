import java.util.Scanner;

public class calculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first no");
        int numberOne = sc.nextInt();
        System.out.println("Enter second no");
        int  numberTwo = sc.nextInt();
        boolean isContinue = true;
        while(isContinue) {
            System.out.println("Enter the operation no you want to perform");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            int operationNumber = sc.nextInt();
            if(operationNumber ==1 || operationNumber == 2 || operationNumber == 3 || operationNumber == 4) {
                switch(operationNumber) {
                    case 1:
                        System.out.println("Addition of " +numberOne+ " and  "+numberTwo+ " is " +(numberOne+numberTwo));
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Subtraction of " +numberOne+ " and  "+numberTwo+ " is " +(numberOne-numberTwo));
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Multiplication of " +numberOne+ " and  "+numberTwo+ " is " +(numberOne*numberTwo));
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Division of " +numberOne+ " and  "+numberTwo+ " is " +(numberOne/numberTwo));
                        System.out.println();
                }
            } else if(operationNumber == 5) {
                isContinue = false;
                System.out.println("Exited!");
            }
            else {
                System.out.println("Enter a valid input");
            }
        }
    }
}
