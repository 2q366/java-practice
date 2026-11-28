import java.util.Scanner;

public class day6Lianxi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int a = sc.nextInt();
        System.out.print("请输入一个整数：");
        int b = sc.nextInt();
        System.out.println((a == 6 || b == 6) + " " + ((a + b) % 6 == 0));
        System.out.println(a == 6 || b == 6 || (a + b) % 6 == 0);
    }
}
