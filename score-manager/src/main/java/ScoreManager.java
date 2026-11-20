public class ScoreManager {
    public static void main(String[] args) {
        // 这里写你的代码：阶段 0 的摸底练习
        int scores[] = {85,92,78,60,99};
        int i;
        //原来写的for(int i = 0;i++;i <= 4)翻书才写出来
        for(i = 0;i < scores.length;i++) {
            System.out.println("成绩：" + scores[i]);
        }
        //用for循环不会，翻书没找到，只能用笨方法
        //int a = scores[0]+scores[1]+scores[2]+scores[3]+scores[4];
        int a = 0;
        for(i = 0;i < scores.length;i++){
            a = a + scores[i];
        }
        double b = a / 5.0;
        System.out.println("总成绩：" + a);
        System.out.println("平均成绩：" + b);
        int max = scores[0];
        int min = scores[0];
        for(int k=1;k < scores.length;k++){
            if(scores[k] > max){
                max = scores[k];
                }
            if (scores[k] < min) {
                min = scores[k];
                }
            }
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
    }
}