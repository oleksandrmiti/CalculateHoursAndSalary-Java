import java.util.Scanner;

/**
 * This program will calculate how many hours I have worked and then output my salary.
 */
public class Main {
    static Scanner sc = new Scanner (System.in); // Create a scanner
    static public boolean Again;
    public static void main(String[] args) {
        Calculate calc = new Calculate(); // Create an object
        do{
            calc.setDays();
            for (int i = 1; i <= calc.days;i++){
                calc.getDayNum(i);
                calc.setStartTime();
                calc.setFinishTime();
                calc.calculateHoursWorked();
            }
            calc.convertOutput();
            calc.outputHoursWorked();
            calc.askUserDoAgain();
        } while(!Again);

    }
}