import java.util.Scanner;

/**
 * This program will calculate how many hours I have worked and then output my salary.
 * Author: Oleksandr Mitichkin
 * Date: 29.07.2023
 * Run program, enter how many days you have worked, enter what time you started and finished for each day.
 * Program will output total hours worked and gross salary for this period.
 */
public class Main {
    static Scanner sc = new Scanner (System.in); // Create a scanner
    static public boolean Again = true;
    public static void main(String[] args) {
        Calculate calc = new Calculate(); // Create an object
        while(Again){
            calc.resetData();
            calc.setDays();
            if (calc.days != 0){
                for (int i = 1; i <= calc.days;i++){
                    calc.getDayNum(i);
                    calc.setStartTime();
                    calc.setFinishTime();
                    calc.calculateHoursWorked();
                }
                calc.convertOutput();
                calc.outputHoursWorked();
                calc.askUserDoAgain();
            }
        }
    }
}