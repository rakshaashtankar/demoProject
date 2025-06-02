import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {

    private int numberOne;
    private int numberTwo;
    private static final String filePath = "/Users/rakshaashtankar/Documents/fullstackProjects/demoProject/history";

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

    private float division() {
        if(numberTwo ==0) {
            display.displayOutput("Number cannot be divided by 0. Cannot perform division.");
        }
        else {
            float output = (float)numberOne / numberTwo;
            History.historyList.add(getFomattedStringForHistory("Division", output));
            return output;
        }
        return 0;
    }

    private String getFomattedStringForHistory(String operation, float output) {
        return operation + " of " + this.numberOne + " and " + this.numberTwo + " is " + output;
    }

    final Display display = new Display();

    void inputNumbers() {
        try{
            String regEx = "\\d+";
            while(true) {
                display.displayOutput("Enter first number");
                String numberOne = sc.next();
                if(numberOne.matches(regEx)) {
                    setNumberOne(Integer.parseInt(numberOne));
                    break;
                } else {
                    display.displayOutput("Please enter a valid first number");
                }
            }
            while(true) {
                display.displayOutput("Enter second number");
                String numberTwo = sc.next();
                if(numberTwo.matches(regEx)) {
                    setNumberTwo(Integer.parseInt(numberTwo));
                    break;
                } else {
                    display.displayOutput("Please enter a valid second number");
                }
            }
        } catch(InputMismatchException e) {
            display.displayOutput("Please enter a valid integer input");
        }

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
                    display.displayOutput("Division", division());
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
            display.displayOutput("Do you want to save history into a file.");
            char response = sc.next().charAt(0);
            if(response == 'y') {
                createFile();
            }


        }
    }

    void createFile() {
        String fileName;
        try{
            LocalDateTime dateTimeNow = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String formattedDateTime = dateTimeNow.format(formatter);
            fileName = formattedDateTime + "_historyLog";
            File directory = new File(filePath);
            if(!directory.exists()) {
                directory.mkdirs();
            }
            File newHistoryFile = new File(filePath+"/"+fileName+".txt");
            newHistoryFile.createNewFile();
            FileWriter fileWriter = null;
            try{
                fileWriter = new FileWriter(newHistoryFile);
                for(String record: History.historyList) {
                    fileWriter.write(record + System.lineSeparator());
                }
                display.displayOutput("History saved successfully to " + newHistoryFile.getAbsolutePath());

            } catch (IOException e) {
                display.displayOutput("Failed to save history" + e.getMessage());
            } finally {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }


        }catch(Exception ex1) {
            display.displayOutput("Failed to create a file." + ex1.getMessage());
        }

    }


}
