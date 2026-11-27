public class Day5 {
    public static void main(String[] args) {

        // ================= 题 1：自增自减预测 =================
        // 规则：先把你猜的答案写在每行右边注释里，再运行核对，猜错了改成「猜X 实际Y」
        int a = 5;
        System.out.println(a++);   // 你猜：5
        System.out.println(a);     // 你猜：6
        System.out.println(++a);   // 你猜：7
        System.out.println(a);     // 你猜：7

        System.out.println("----------");

        // 陷阱题：先想 30 秒再跑
        int i = 1;
        i = i++;
        System.out.println("i = " + i);   // 你猜：2 猜错，实际i = 1

        System.out.println("----------");

        // ================= 题 2：复合赋值五连 + short 实验 =================
        int x = 10;
        x += 5;//15
        System.out.println("x += 5 -> " + x);
        // TODO: 接着写 x -= 3; x *= 2; x /= 5; x %= 3; 每步都打印
        x -= 3;//12
        System.out.println("x -= 3 ->" + x);
        x *= 2;//24
        System.out.println("x *= 2 ->" + x);
        x /= 5;//4
        System.out.println("x /= 5 ->" + x);
        x %= 3;//1
        System.out.println("x %= 3 ->" + x);

        // TODO: short 实验
        // short s = 10; s += 5; 打印 s
        // 然后把 s += 5; 改成 s = s + 5; 看报什么错，把报错原文抄在下面注释里：
        // 报错原文：不兼容的类型。实际为 int'，需要 'short'
        short s = 10;
        s += 5;
        //s = s + 5;
        System.out.println(s);

        System.out.println("----------");

        // ================= 题 3：关系运算符 =================
        int score = 78;
        // TODO: 打印 score >= 60
        // TODO: 打印 score == 100
        // TODO: 用三元直接输出 及格/不及格
        // TODO: 打印 'a' < 'b'  和  'A' == 65
        System.out.println(score >= 60);//true
        System.out.println(score == 100);//false
        System.out.println(score >= 60 ? "及格" : "不及格");
        System.out.println("'a' < 'b' -> " + ('a' < 'b') + " 'A' == 65 ->" + ('A' == 65));
    }
}
