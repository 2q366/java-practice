import java.util.Scanner;
class Animal{
    public void say(){
        System.out.println("动物叫");
    }
}
class Dog extends Animal{
    @Override
    public void say(){
        System.out.println("汪汪汪");
    }
}
class Cat extends Animal {
    @Override
    public void say() {
        System.out.println("喵喵喵");
    }
}

class Shape{
    public double area(){
        return 0;
    }
    public String name(){
        return "图形";
    }
}
class Rect extends Shape{
    double w,h;
    @Override
    public double area(){
        return (w * h);
    }
    public String name(){
        return "长方形";
    }
}
class Circle extends Shape{
    double r;
    public Circle(double r){
        this.r = r;
    }
    @Override
    public double area(){
        return (3.14 * r * r);
    }
    public String name(){
        return "圆";
    }
}
public class jialian1225 {
    public static void main(String[] args){
        //A1 一件商品原价 `200` 元，打 85 折。输出折后价，**保留 2 位小数**。
        System.out.printf("%.2f",200 * 0.85);
        System.out.println();
        //A2 读一个三位数，把它反过来输出。**只能用 `/` 和 `%`，不许用字符串、不许用 StringBuilder。**
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个三位数：");
        int s = sc.nextInt();
        System.out.println((s % 10) * 100 + (s / 10) % 10 * 10 + s / 100);
        //A3 给定 `2` 时 `30` 分 `45` 秒，算出总共多少秒。
        int c1 = 2,c2 = 30,c3 = 45;
        c3 = ((c1 * 60) + c2) * 60 + c3;
        System.out.println(c3);
        //A4 读一个整数，判断它能不能**同时**被 3 和 5 整除。
        System.out.print("请输入一个整数：");
        int b1 = sc.nextInt();
        boolean b2;
        //if (b1 % 3 == 0 && b1 % 5 == 0) b2 = true;//我觉得这个方便，因为更容易明白是什么条件
        //else b2 = false;
        if (b1 % (3 * 5) == 0) b2 = true;
        else b2 = false;
        System.out.println((b2 ? "此数能同时被3和5整除" : "此不数能同时被3和5整除"));
        //B1
        /*Animal a1 = new Cat();
        Animal a2 = new Dog();
        a1.say();
        a2.say();
        String[] Animal = {"a1","a2","animal"};
        for (String a3 : Animal){
            System.out.println(a3.say());
        }*/ //不会在循环中调用方法
        //B2
        String[] Shape = {"长方形(3,4)","圆(2)","长方形(5,5)"};
        Shape x1 = new Rect();
        x1.area();
        x1.name();
        System.out.println(x1.name() + "的面积是" + x1.area());
        Shape x2 = new Circle(2);
        x2.area();
        x2.name();
        System.out.println(x2.name() + "的面积是" + x2.area());
        Shape x3 = new Rect();
        x3.area();
        x3.name();
        System.out.println(x3.name() + "的面积是" + x3.area());
        System.out.println("总面积是：" + (x1.area() + x2.area() + x3.area()) + "，平均面积是：" + (x1.area() + x2.area() + x3.area()) / 3);
        double y;
        if (x1.area() > x2.area()){
            y = x1.area();
            if (x1.area() > x3.area()){
                y = x1.area();
                System.out.println("面积最大的是：" + x1.name() + " 面积为：" + y);
            }
            else {
                y = x3.area();
                System.out.println("面积最大的是：" + x3.name() + " 面积为：" + y);
            }
        }
        else {
            y = x2.area();
            if (x2.area() > x3.area()){
                y = x2.area();
                System.out.println("面积最大的是：" + x2.name() + " 面积为：" + y);
            }
            else {
                y = x3.area();
                System.out.println("面积最大的是：" + x3.name() + " 面积为：" + y);
            }
        }
        //B3
        //①Dog类s大写了，重写不能改变方法名。声明不变，重新实现
        //②Dog没有继承父类，不能用重写
        //③Dog类的数据类型和父类不一样
        //④private是私有方法，不能被继承
    }
}
