import java.util.Scanner;

public class Examples1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int count = 0, sum = 0, avg = 0, max = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (max < digit){
                max = digit;
            }
            sum += digit;
            count++;
        }
        avg = sum / count;
        System.out.println("Number Entered: " + number + "\nMax Digit: " + max + "\nCount Digits: " + count + "\nSum Digits: " + sum + "\nAvg: " + avg);
    }
}
