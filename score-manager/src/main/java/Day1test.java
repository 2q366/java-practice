import java.util.Scanner;
public class Day1test {
    public static void main(String[] args){
        //问了deepseek怎么输入并应用
        System.out.println("请输入温度：");
        Scanner number = new Scanner(System.in);
        double F;
        double C = number.nextDouble();
        F = (C * 9) / 5 + 32;
        System.out.printf(" %.1f",F);
        System.out.println();

        System.out.println("请输入商品价值：");
        int x = number.nextInt();
        System.out.println("请输入你给的钱：");
        int y = number.nextInt();
        int z = y - x;
        if(z < 0) System.out.println("钱不够！");
        else {
            System.out.println("应找你：");
            System.out.println("50元：" + z / 50 + "张");
            z = z - 50 * (z / 50);
            System.out.println("20元：" + z / 20 + "张");
            z = z - 20 * (z / 20);
            System.out.println("10元：" + z / 10 + "张");
            z = z - 10 * (z / 10);
            System.out.println("5元：" + z / 5 + "张");
            z = z - 5 * (z / 5);
            System.out.println("1元：" + z + "张");
        }
    }
}
