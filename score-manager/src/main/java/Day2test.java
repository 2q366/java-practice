import java.util.Scanner;
public class Day2test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要换算的时间（秒）：");
        int miao = sc.nextInt();
        int shi = miao / 3600;
        int fen = (miao / 60) - (shi * 60);
        System.out.println("换算后的时间是：" + shi + "小时"+ fen + "分钟" + miao % 60 + "秒");

        System.out.print("请输入分数：");
        int score = sc.nextInt();
        boolean x = false;
        if (score >= 60) x = true;
        System.out.println("成绩" + score + "分" + (x ? "及格" : "不及格"));

        int price = 100;
        double rate = 0.85;
        double pay = price * rate;
        String level;
        if (pay > 80) level = "贵";
        else level = "便宜";
        System.out.println("实付：" + pay + "，等级：" + level);
        double a = 7, b = 2;
        System.out.println("平均：" + (a + b) / 2);

        double pi = 3.14159;
        System.out.println((int)pi + " " + Math.round(pi));//int是直接取整数部分
        System.out.printf("%.0f", pi );//不知道这种格式要用,之前用的+报错，问的deepseek才解决
        System.out.println();

        int sum = 248;
        System.out.println(sum / 3);
        System.out.println(sum / 3.0);
        System.out.println((double) sum / 3);
        System.out.printf("%.2f", sum / 3.0);//要加3.0，加3会报错

        /*String y = sc.nextLine();
        System.out.println(y);
        System.out.println(x);
        String name = "黑马谢广坤";
        int age = 18;
        double high = 180.1;
        char gender = '男';
        boolean flag = true;
        System.out.println(name);
        System.out.println(age);
        System.out.println(high);
        System.out.println(gender);
        System.out.println(flag);
        String name = "送初恋回家";
        String name1 = "刘鑫";
        String name2 = "张雨提";
        String name3 = "高媛";
        int age = 2020;
        double fen = 9.0;
        System.out.println("电影名："+ name);
        System.out.println("主演："+ name1 +","+ name2 +","+ name3 );
        System.out.println("年份："+ age);
        System.out.println("评分："+ fen);
        double qian = 1699;
        String pai = "荣耀";
        System.out.println(qian);
        System.out.println(pai);*/
    }
}
