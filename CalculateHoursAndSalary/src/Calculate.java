import java.text.DecimalFormat;

/**
 * Ask how many days I'm working
 * Start asking for each day what time am I starting and what time finishing
 * Calculate
 * Output all information with total our worked, my rate and total salary for week.
 */
public class Calculate {

    public int days;
    private int totalHours, totalMinutes, hoursStart, hoursFinish, minutesStart, minutesFinish, finalMinutes, finalHours;
    private float totalSalary,convertedMinutesToHours;
    private boolean validDays, doQuotationAgain;
    private String askAgain;
    private double rate = 11.3;

    DecimalFormat money = new DecimalFormat("\u20AC0.00"); //Decimal format for Euro character that showing 2 number after dot


    public Calculate(){
        totalHours = 0;
        totalMinutes = 0;
        totalSalary = 0;
        hoursStart = 0;
        hoursFinish = 0;
        minutesStart = 0;
        minutesFinish = 0;
    }

    public void resetData(){
        totalHours = 0;
        totalMinutes = 0;
        totalSalary = 0;
        hoursStart = 0;
        hoursFinish = 0;
        minutesStart = 0;
        minutesFinish = 0;
    }
    public void setDays(){
        do {
            try {
                System.out.print("Enter how many days you are working: ");
                days = Main.sc.nextInt();
                validDays = true;
            }
            catch(java.util.InputMismatchException e){
                System.err.print("Please use numbers.\n");
                Main.sc.next();
            }
        } while (!validDays);
    }
    public void getDayNum(int dayNumber){
        System.out.print("\nEnter details for day #"+ dayNumber);
    }
    public void setStartTime(){
        do {
            System.out.print("\nEnter what time are you starting, firstly enter hours and then minutes.");
            try {
                System.out.print("\nEnter hours: ");
                hoursStart = Main.sc.nextInt();
                if(hoursStart == 0){
                    Main.Again = false;
                }
                validDays = true;
            }
            catch(java.util.InputMismatchException e){
                System.err.print("Please use numbers.\n");
                Main.sc.next();
            }

        } while (!validDays);
        System.out.print("Enter minutes: ");
        minutesStart = Main.sc.nextInt();
    }
    public void setFinishTime(){
        System.out.print("\nEnter what time are you finishing, firstly enter hours and then minutes.");
        System.out.print("\nEnter hours: ");
        hoursFinish = Main.sc.nextInt();
        System.out.print("Enter minutes: ");
        minutesFinish = Main.sc.nextInt();
    }
    public void calculateHoursWorked(){
        if(minutesStart<minutesFinish){
            hoursFinish=hoursFinish-1;
            minutesFinish+=60;
        }
        finalHours = hoursFinish - hoursStart;
        finalMinutes = minutesFinish - minutesStart;
        totalHours += finalHours;
        totalMinutes += finalMinutes;
    }
    private void setMinutesToHours(){
    convertedMinutesToHours = totalMinutes/60f;
    }
    public void convertOutput(){
        do{
            totalMinutes-=60;
            totalHours+=1;
        }while (totalMinutes > 60);
    }
    public void calculateSalary(){
        setMinutesToHours();
        totalSalary = (float) ((totalHours+convertedMinutesToHours) * rate);
    }
    public void outputHoursWorked(){
        calculateSalary();
        System.out.print("\n\nTotal:");
        System.out.print("\nHours worked: "+totalHours+":"+totalMinutes);
        System.out.print("\nYour salary for this period: "+money.format(totalSalary));
    }


    public void askUserDoAgain(){
        doQuotationAgain = false;
        // While loop
        do {
            System.out.println("\nDo you want to make another quotation, Y/N?");
            System.out.print("\nPlease enter your answer: "); // Asking user to enter an answer
            askAgain = Main.sc.next();
            switch (askAgain) {
                case "Y": case "y": Main.Again = true; doQuotationAgain = true;
                    break;
                case "N": case "n": Main.Again = false;  doQuotationAgain = true;
                    break;
                default:
                    System.err.println("Enter Y or N.");
            }
        } while (!doQuotationAgain);
    }
}
