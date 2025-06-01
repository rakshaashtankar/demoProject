import java.util.Scanner;

public class calculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first no");
        int a = sc.nextInt();
        System.out.println("Enter second no");
        int b = sc.nextInt();
        boolean isContinue = true;
        while(isContinue) {
            System.out.println("Enter the operation no you want to perform");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            int no = sc.nextInt();
            if(no==1 || no ==2 || no==3 || no ==4) {
                switch(no) {
                    case 1:
                        System.out.println("Addition of " +a+ " and  "+b+ " is " +(a+b));
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Subtraction of " +a+ " and  "+b+ " is " +(a-b));
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Multiplication of " +a+ " and  "+b+ " is " +(a*b));
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Division of " +a+ " and  "+b+ " is " +(a/b));
                        System.out.println();
                }
            } else if(no == 5) {
                isContinue = false;
                System.out.println("Exited!");
            }
            else {
                System.out.println("Enter a valid input");
            }
        }
    }
}
