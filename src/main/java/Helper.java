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
        int output = numberOne + numberTwo;
        History.historyList.add(getFomattedStringForHistory("Addition", output));
        return output;

    }

    private int subtraction() {
        int output = numberOne - numberTwo;
        History.historyList.add(getFomattedStringForHistory("Subtraction", output));
        return output;
    }

    private int multiplication() {
        int output = numberOne * numberTwo;
        History.historyList.add(getFomattedStringForHistory("Multiplication", output));
        return output;
    }

    private int division() {
        int output = numberOne / numberTwo;
        History.historyList.add(getFomattedStringForHistory("Division", output));
        return output;
    }

    private String getFomattedStringForHistory(String operation, int output) {
        return operation + " of " + this.numberOne + this.numberTwo + " is " + output;
    }

    final Display display = new Display();

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
            if(operationNumber == 6) {
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
                    try{
                        display.displayOutput("Division", division());
                    } catch (ArithmeticException e) {
                        display.displayOutput("Error dividing by 0");
                    }
                    break;
                case 5:
                    getHistory();
                    break;
                default:
                    display.displayInvalidInput();
            }
        }
    }

    void getHistory() {
        if(History.historyList.isEmpty()) {
            display.displayOutput("No history found.");
        } else {
            for (String s : History.historyList) {
                display.displayOutput(s);
            }
        }
    }
}
