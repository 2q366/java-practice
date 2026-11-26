public class Day4 {
    public static void main(String[] args) {

        // ===== 一、看视频时随手验证：隐式转换（小 -> 大，自动） =====
        int i = 100;
        long l = i;          // int 自动变 long
        double d = l;        // long 自动变 double
        System.out.println("隐式: " + i + " / " + l + " / " + d);

        // ===== 二、强制转换（大 -> 小，要写括号，可能丢东西） =====
        double pi = 3.99;
        int cut = (int) pi;  // 砍掉小数，不是四舍五入
        System.out.println("(int)3.99 = " + cut);
        System.out.println("Math.round(3.99) = " + Math.round(pi));

        int big = 200;
        byte b = (byte) big; // 200 超出 byte 范围(-128~127)，溢出变成负数
        System.out.println("(byte)200 = " + b);

        // ===== 三、字符和加号 =====
        char c = 'a';
        System.out.println("c + 1 = " + (c + 1));            // 数字 98
        System.out.println("(char)(c+1) = " + (char)(c + 1)); // 字符 b
        System.out.println("'A' + 1 = " + ('A' + 1));        // 66
        System.out.println("(char)('A'+1) = " + (char)('A' + 1)); // B

        // ===== 四、字符串拼接的陷阱 =====
        System.out.println("结果：" + 1 + 2);   // 拼接：结果：12
        System.out.println(1 + 2 + "结果");     // 先加：3结果
        System.out.println('a' + 'b');          // 195（两个字符相加是数字）
        System.out.println('a' + 'b' + "c");    // 195c
        System.out.println('a' + "" + 'b');     // ab（夹个空串就变拼接）

        // ===== TODO 自己写（写在这条线下面） =====
        // 题1：double d2 = 3.99; 分别用 (int) 和 Math.round 打印，对比
        // 题2：先猜 "结果：" + 1 + 2 和 1 + 2 + "结果" 各是什么，再跑核对
        // 题3：char c2='a'; 打印 c2+1 与 (char)(c2+1)；再试 'A'+1
        double d2 = 3.99;
        System.out.println((int)d2);
        System.out.println(Math.round(d2));
        //"结果12"  "3结果"
        System.out.println("结果" + 1 + 2);
        System.out.println(1 + 2 + "结果");
        //98 b 66 B
        char c2 = 'a';//a = 97，A = 65
        System.out.println(c2 + 1);
        System.out.println((char)(c2 + 1));
        System.out.println('A' + 1);
        System.out.println((char)('A' + 1));
    }
}
