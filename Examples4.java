import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        //Input => number 1 - 2
        //Output => +; -; *; /; %;
        float number1 = 0, number2 = 0;
        float jam = 0, tafrigh = 0, zarb = 0, taghsim = 0;
        int baghimande = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا عدد اول را وارد کنید:");
        number1 = input.nextFloat();
        System.out.print("لطفا عدد دوم را وارد کنید:");
        number2 = input.nextFloat();
        jam = number1 + number2;
        tafrigh = number1 - number2;
        zarb = number1 * number2;
        taghsim = number1 / number2;
        //Convert Float to int :
        // #01
        int n1 = Math.round(number1);//Convert Float to Int
        int n2 = Math.round(number2);//Convert Float to Int
        //#02
        //int n1 = Integer.parseInt(String.valueOf(number1).split("\\.")[0]);
        //int n2 = Integer.parseInt(String.valueOf(number2).split("\\.")[0]);
        baghimande = n1 % n2;
        System.out.println(number1 + " + " + number2 + " = " + jam);
        System.out.println(number1 + " - " + number2 + " = " + tafrigh);
        System.out.println(number1 + " * " + number2 + " = " + zarb);
        System.out.println(number1 + " / " + number2 + " = " + taghsim);
        System.out.println(n1 + " % " + n2 + " = " + baghimande);
    }
}
