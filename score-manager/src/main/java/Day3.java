import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {

        // ============ 第 1 段：键盘录入（P26） ============
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("你今年 " + age + " 岁");

        // ============ 第 2 段：算术运算符（P30） ============
        int a = 7, b = 2;
        System.out.println("a + b = " + (a + b));   // 9
        System.out.println("a - b = " + (a - b));   // 5
        System.out.println("a * b = " + (a * b));   // 14
        System.out.println("a / b = " + (a / b));   // 3  ← 整数除法，小数被扔掉
        System.out.println("a % b = " + (a % b));   // 1  ← 余数

        // 想得到 3.5，必须让其中一边变成小数
        System.out.println("真除法 = " + ((double) a / b));

        // ============ 第 3 段：今天的 3 道题，在下面写 ============

        // ---------- 题 1：四则运算计算器 ----------
        // 用 Scanner 读两个整数，输出 + - * / % 五个结果
        // 要求：/ 保留 2 位小数
        // TODO 1：在这里写
        


        // ---------- 题 2：负数取余（先猜再运行） ----------
        // 把下面四行先写成注释猜答案，再取消注释运行对答案
        // System.out.println(7 % 3);
        // System.out.println(-7 % 3);
        // System.out.println(7 % -3);
        // System.out.println(-7 % -3);
        // TODO 2：在这里写


        // ---------- 题 3：三位数拆位 ----------
        // 读一个三位数，拆出百位、十位、个位
        // 只能用 / 和 %，不许用字符串
        // TODO 3：在这里写


    }
}
