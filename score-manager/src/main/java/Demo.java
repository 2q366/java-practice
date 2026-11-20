public class Demo {
    public static void main(String[] args) {
        int scores[] = {85, 92, 78, 60, 99};

        // 写法一：单条语句，可以省略大括号
        int a = 0;
        for (int k = 0; k < scores.length; k++)
            a += scores[k];
        System.out.println("写法一（无大括号）总和 = " + a);

        // 写法二：加大括号，完全等价
        int b = 0;
        for (int k = 0; k < scores.length; k++) {
            b += scores[k];
        }
        System.out.println("写法二（有大括号）总和 = " + b);

        // 写法三：展开 a += scores[k] 的真面目
        int c = 0;
        for (int k = 0; k < scores.length; k++) {
            c = c + scores[k];
        }
        System.out.println("写法三（c = c + scores[k]）总和 = " + c);

        // 反例：把 a 声明在循环里面 —— 每轮都被清零
        for (int k = 0; k < scores.length; k++) {
            int d = 0;
            d += scores[k];
        }
        System.out.println("（反例 d 在循环内声明，循环外拿不到，也累加不出来）");
    }
}
