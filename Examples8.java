import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        //Input => Year
        //Output => Months of Years; Days of Years; Seconds of Years;
        int years = 0;
        int months = 0, days = 0;
        long seconds = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا سال را وارد کنید:");
        years = input.nextInt();
        months = years * 12;
        days = years * 365;
        seconds = 24L * 60 * 60 * days;
        System.out.println("Months = " + months);
        System.out.println("Days = " + days);
        System.out.println("Seconds = " + seconds);
    }
}
