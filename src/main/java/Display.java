public class Display {
    void displayOutput(String operationName, int output) {
        System.out.println(operationName + " is : " + output);
        System.out.println();
    }
    void displayOutput(String output) {
        System.out.println(output);
    }
    void displayMenu() {
        System.out.println("Enter the operation no you want to perform");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Get History");
        System.out.println("6. Exit");
    }

    void displayInvalidInput() {
        System.out.println(("Enter valid input"));
    }

    void displayExit() {
        System.out.println("Exited!");
    }
}
