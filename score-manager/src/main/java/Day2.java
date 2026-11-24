public class Day2 {
    public static void main(String[] args) {

        // ============ 第 1 段：一行定义多个变量（P24 会讲到） ============
        int a = 1, b = 2, c = 3;
        System.out.println("一行定义三个：a=" + a + " b=" + b + " c=" + c);

        // 连续赋值：从右往左算，a 和 b 都变成 10
        int x, y;
        x = y = 10;
        System.out.println("连续赋值：x=" + x + " y=" + y);

        // ============ 第 2 段：标识符规范演示（P25 会讲到） ============
        // 小驼峰：变量、方法
        String studentName = "陈喻涛";
        // 大驼峰：类（本文件顶上的 Day2 就是）
        // 全大写：常量，final 表示不能再改
        final int MAX_SCORE = 100;

        System.out.println("学生：" + studentName + "，满分：" + MAX_SCORE);

        // ============ 第 3 段：今天的 3 道题，在下面写 ============

        // ---------- 题 1：用 5 个变量介绍你自己 ----------
        // 提示：String / int / double / char / boolean 各一个
        // 写完打印：我叫XX，今年XX岁，身高X.XX米，性别X，是在校学生。
        // TODO 1：在这里写你的 5 个变量
        String name = "陈喻涛";
        int age = 20;
        double height = 1.75;
        char xing = '男';
        boolean xiao = true;
        System.out.println("我叫" + name + "，今年" + age + "岁，身高" + height + "米，性别" + xing + "，" + (xiao ? "是在校学生" : "不是在校学生"));//不会打印boolaen类型,加括号一开始加成中文括号了，报错
        // ---------- 题 2：把 5 个错名字改对 ----------
        // 原题：
        // int 2score = 90;
        //   int class = 3;
        //   int my-score = 88;
        //   String studentname1 = "张三";
        //   int MAX = 100;
        // TODO 2：在这里写改对后的 5 行，每行后面用 // 注释写「原来错在哪」
        int score2 = 90;//标识符不能以数字开头
        int classNum = 3;//标识符不能是关键字
        int my_score = 88;//标识符不能有-
        String studentName1 = "张三";//第二个单词要大写，上面已经定义了studentName,所以改成了studentName1
        final int MAX = 100;//全大写表示常量,要加final
        System.out.println(score2 +" "+ classNum +" "+ my_score +" "+ studentName1 +" "+ MAX);

        // ---------- 题 3：三科成绩求总分和平均分 ----------
        // 要求：平均分要带小数（想想怎么避开整数除法）
        // TODO 3：在这里写
        int c1 = 85, c2 = 73, c3 = 90;
        double num = c1 + c2 + c3;
        double avg = num / 3.0;
        System.out.println(num +" "+ avg);
    }
}
