import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        //Input => Age
        //Output => Minutes of Age;
        int age = 0;
        int minutes = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا سنتان را وارد کنید:");
        age = input.nextInt();
        minutes = age * 365 * 24 * 60;
        System.out.println("Minutes = " + minutes);
    }
}
