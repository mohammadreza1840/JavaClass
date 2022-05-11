import java.util.Scanner;

public class Examples1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int count = 0, sum = 0, avg = 0, max = 0;
        int outNumber = number;
        while (number > 0) {
            int digit = number % 10;
            if (max < digit) {
                max = digit;
            }
            sum += digit;
            count++;
            number = number / 10;
        }
        avg = sum / count;
        System.out.println("Number Entered: " + outNumber + "\nMax Digit: " + max + "\nCount Digits: " + count + "\nSum Digits: " + sum + "\nAvg: " + avg);
    }
}
