import java.util.Scanner;

public class Helper {

    private final int numberOne;
    private final int numberTwo;

    Helper(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    Display obj = new Display();

    boolean operate() {
        System.out.println("Enter the operation no you want to perform");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        Scanner sc = new Scanner(System.in);
        int operationNumber = sc.nextInt();
        if(operationNumber ==1 || operationNumber == 2 || operationNumber == 3 || operationNumber == 4) {
            switch(operationNumber) {
                case 1:
                    obj.displayOutput("Addition", (numberOne+numberTwo));
                    break;
                case 2:
                    obj.displayOutput("Subtraction", (numberOne-numberTwo));
                    break;
                case 3:
                    obj.displayOutput("Multiplication", (numberOne*numberTwo));
                    break;
                case 4:
                    obj.displayOutput("Division", (numberOne/numberTwo));
            }
        } else if(operationNumber == 5) {
            System.out.println("Exited!");
            return false;
        }
        else {
            System.out.println("Enter a valid input");
        }
        return true;
    }


}
