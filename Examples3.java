import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        //Input => گنجایش باک ماشین - مصرف صد کیلومتر به لیتر
        //Output => میزان مسافت قابل طی کردن با یک باک
        float gonjayesh = 0, masraf = 0;
        float masafat = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("لطفا میزان مصرف صد کیلومتر به لیتر را وارد کنید:");
        masraf = input.nextFloat();
        System.out.print("لطفا گنجایش باک را وارد کنید:");
        gonjayesh = input.nextFloat();
        masafat = (gonjayesh / masraf) * 100;
        System.out.println("میزان مسافت قابل پیمایش با باک پر ماشین شما:" + masafat);
    }
}
