import java.util.Scanner;

public class Examples {
    public static void main(String[] args){
        //Input => ارتفاع و قاعده مثلث
        //Output => مساحت مثلث
        int ertefa = 0,ghaede = 0;
        int masahat = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا ارتفاع مثلث را وارد کنید:");
        ertefa = input.nextInt();
        System.out.print("لطفا قاعده مثلث را وارد کنید:");
        ghaede = input.nextInt();
        masahat = (ertefa * ghaede)/2;
        System.out.println("مساحت مثلث شما:" + masahat);
    }
}
