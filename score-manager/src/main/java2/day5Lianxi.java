import java.util.Scanner;

public class day5Lianxi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的时髦度(1~10)：");
        int a = sc.nextInt();
        System.out.print("请输入对象的时髦度：");
        int b = sc.nextInt();
        System.out.println(a > b ? "true" : "false");
        int c = 5;
        System.out.println(c++);
        System.out.println(++c);
    }
}
