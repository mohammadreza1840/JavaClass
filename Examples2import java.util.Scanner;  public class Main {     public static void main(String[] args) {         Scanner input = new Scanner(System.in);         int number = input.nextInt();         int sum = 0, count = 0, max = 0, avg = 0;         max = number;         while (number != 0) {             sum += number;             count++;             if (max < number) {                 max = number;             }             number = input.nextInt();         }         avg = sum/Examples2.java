import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int sum = 0, count = 0, max = 0, avg = 0;
        max = number;
        while (number != 0) {
            sum += number;
            count++;
            if (max < number) {
                max = number;
            }
            number = input.nextInt();
        }
        avg = sum / count;
        System.out.println("Count : " + count + "\nSum : " + sum + "\nAvg : " + avg + "\nMax : " + max);
    }
}
