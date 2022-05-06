import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String x = input.nextLine();
        String chap = "";
        for (int i = x.length();i >= 0;i--){
            chap += x.charAt(i);
        }
        System.out.println(chap);
    }
}
