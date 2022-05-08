import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        //Input => number 1
        //Output => number^2; number^3;
        int number = 0;
        int squre = 0, cube = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا عدد را وارد کنید:");
        number = input.nextInt();
        squre = number * number;
        cube = squre * number;
        System.out.println(number + " ^ " + "2 = " + squre);
        System.out.println(number + " ^ " + "3 = " + cube);
    }
}
