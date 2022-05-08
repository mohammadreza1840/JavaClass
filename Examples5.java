import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        //Input => number 1 - 2 - 3
        //Output => +; *; avg;
        float number1 = 0, number2 = 0, number3 = 0;
        float jam = 0, zarb = 0, miangin = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا عدد اول را وارد کنید:");
        number1 = input.nextFloat();
        System.out.print("لطفا عدد دوم را وارد کنید:");
        number2 = input.nextFloat();
        System.out.print("لطفا عدد سوم را وارد کنید:");
        number3 = input.nextFloat();
        jam = number1 + number2 + number3;
        zarb = number1 * number2 * number3;
        miangin = jam / 3;
        System.out.println(number1 + " + " + number2 + " + " + number3 + " = " + jam);
        System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + zarb);
        System.out.println("Avg: " + miangin);
    }
}
