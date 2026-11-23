public class Day1 {
    public static void main(String[] args) {

        // ========== 一、变量三要素（P19/P20 的内容）==========
        int age = 18;                       // int(类型=整数) age(名字) 18(值)
        System.out.println(age);            // 18
        age = 20;                           // 值可以改
        System.out.println(age);            // 20

        String name = "陈喻涛";              // String = 文字（双引号）
        System.out.println(name + " 今年 " + age + " 岁");


        // ========== 二、四个基本类型（P23 的内容）==========
        int    num    = 100;                // 整数
        double price  = 3.14;               // 小数
        char   grade  = 'A';                // 单个字符（单引号，只能一个）
        boolean pass  = true;               // 真 / 假
        System.out.println(num + " " + price + " " + grade + " " + pass);


        // ========== TODO 1：跑一次，看输出 ==========
        // 然后故意改错：把 price 那行的 double 改成 int，看 IDEA 报什么红字。
        // 你会看到：不兼容的类型：从 double 转换到 int 可能会有损失
        // 看懂这句红字，你就懂了"为什么 3.14 不能用 int 装"。看完记得改回来。


        // ========== TODO 2：自己加一个变量 ==========
        // 加一行  long  big = 3000000000L;   然后 println 它。
        // 注意末尾的 L —— 因为 30 亿超过了 int 的上限（约 21 亿），不加 L 会报错。
        // 写在这里 ↓
        long big = 3000000000L;
        float smill = 6.66F;
        System.out.println(big);
        System.out.println(smill);

        // ========== TODO 3：char 的秘密 ==========
        // 加一行  System.out.println((int) grade);
        // 跑一下，看 'A' 打印成什么数字（提示：65）。
        // 这说明计算机里"字符"其实也是用数字存的。
        System.out.println((int) grade);
    }
}
