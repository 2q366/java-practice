public class Hello {
    public static void main(String[] args) {
        System.out.println("你好，Java！这是我的第一个程序。");
        System.out.println("今天日期：2026-11-19");
        System.out.println("环境：JDK " + System.getProperty("java.version"));

        // 小练习：算 1 加到 100
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1 加到 100 = " + sum);
    }
}