import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        //Input => Radius
        //Output => Circle => P; S;
        float radius = 0;
        double p = 0, s = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا شعاع را وارد کنید:");
        radius = input.nextFloat();
        p = (radius * 2) * Math.PI;
        s = (radius * radius) * Math.PI;
        System.out.println("P = " + p);
        System.out.println("S = " + s);
    }
}
