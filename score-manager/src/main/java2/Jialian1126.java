/*import java.util.Scanner;
abstract class Fu{
    abstract int fu(int x);
}
class Zi extends Fu{
    @Override
    int fu(int x){
        //我记得这里子类要重写父类啊；为什么加重写关键字会报错
        System.out.println(x % 12 == 0 ? "能同时被4和6整除" : "不能同时被4和6整除");
        return x;
    }
}
public class Jialian1126 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //1:
        int a = 5,b = 9;
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println("a = " + a + " b = " + b);
        //2:
        System.out.print("请输入一个四位数：");
        int n = sc.nextInt();
        System.out.println(n / 1000 + n % 1000 / 100 + n % 100 / 10 + n % 10);
        //3: 33 123 98
        System.out.println(1 + 2 + "3");
        System.out.println("1" + 2 + 3);
        System.out.println('a' + 1);
        //4: 7 8 B
        //5:
        System.out.print("请输入一个整数：");
        int m = sc.nextInt();
        System.out.println((m % 2 == 0 ? "偶数" : "奇数"));
        //6:创建一个抽象父类Fu，其中有一个抽象方法f,创建一个子类，继承Fu类，并重写其中的方法,从键盘录入一个数，判断是否能被4和6同时整除
        //并输出这个数和'e'，"块钱"相加的结果
        System.out.print("请输入一个整数：");
        int f = sc.nextInt();
        Fu y = new Zi();//这里记错了，记成这里的括号里加对象
        y.fu(f);
        System.out.println(f + 'e' + "块钱");
        System.out.println(f + "" + 'e' + "块钱");
    }
}*/
