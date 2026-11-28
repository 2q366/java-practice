import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {

        // ============ 题 1：P35 补测（先写注释猜，再跑） ============
        int a = 10, b = 20;
        System.out.println(a > 5 & b < 30);    // 猜：
        System.out.println(a > 5 | b < 10);    // 猜：
        System.out.println(a > 5 ^ b > 30);    // 猜：
        System.out.println(!(a > b));          // 猜：

        System.out.println("----------");

        // ============ 题 2：闰年判断 ============
        // TODO: 用下面的式子分别测 2024 / 1900 / 2000 / 2023
        // boolean leap = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
        // 先猜四个答案，写在注释里：


        System.out.println("----------");

        // ============ 题 3：短路实验（最重要） ============
        int c = 0;
        boolean r = (c != 0) && (10 / c > 1);   // 第1步：先跑这个，看崩不崩
        System.out.println(r);

        // 第2步：把上面的 && 改成 & ，再跑一次，把报错抄在这里：
        // 报错原文：

        // 第3步：想明白为什么，一句话写在下面：
        // 原因：

        System.out.println("----------");

        // ============ 今天练：输入 3 个数，从大到小输出 ============
        // 提示：三次比较 a-b、a-c、b-c，靠 if + 三行交换
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入 3 个整数：");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        // TODO: 比较并交换

        // TODO: 输出
    }
}
