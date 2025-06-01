import java.util.Scanner;

public class Helper {

    private int numberOne;
    private int numberTwo;

    Scanner sc = new Scanner(System.in);

    void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }


    private int addition() {
        return numberOne+numberTwo;
    }

    private int subtraction() {
        return numberOne-numberTwo;
    }

    private int multiplication() {
        return numberOne*numberTwo;
    }

    private int division() {
        return numberOne/numberTwo;
    }

    Display display = new Display();

    void inputNumbers() {
        display.displayOutput("Enter first no");
        setNumberOne(sc.nextInt());
        display.displayOutput("Enter second no");
        setNumberTwo(sc.nextInt());
    }

    void operate() {
        boolean isContinue = true;
        while(isContinue) {
            display.displayMenu();
            int operationNumber = sc.nextInt();
            if(operationNumber == 5) {
                display.displayExit();
                isContinue = false;
            }
            switch(operationNumber) {
                case 1:
                    display.displayOutput("Addition", addition());
                    break;
                case 2:
                    display.displayOutput("Subtraction", subtraction());
                    break;
                case 3:
                    display.displayOutput("Multiplication", multiplication());
                    break;
                case 4:
                    display.displayOutput("Division", division());
                default:
                    display.displayInvalidInput();
            }
        }
    }
}
