public class Test {
    public static void main(String[] args){
        for(int i = 1;i <= 100;i++){
            if(i % 2 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        int a = 0;
        for(int i = 1;i <= 50;i++){
            a = a + 2;// a += 2;
            System.out.print(a + " ");
        }
        System.out.println();

        for(int i = 0;i <= 100;i += 2){
            System.out.print(i + " ");
        }
        System.out.println();

        int sum = 0;
        int qi = 0;
        for (int i = 0;i <= 100;i++){
            sum += i;
            if(i % 7 == 0){
                qi += i;
            }
        }
        System.out.println(sum - qi);

        int[] b = {9,1,2};//{3,7,2,9,5,9,1};
        int max = b[0];
        int second = Integer.MIN_VALUE;
        for (int x : b){//(int i = 0;i < b.length;i++) {
            if (max < x) {
                max = x;
            }
        }
        for (int x : b){//(int i = 0;i < b.length;i++){
            if (max > x && second < x) {
                second = x;
            }
        }
        System.out.println(max + " " + second);

        int n = 4;
        boolean isPrime = true;
        if(n <= 1){
            isPrime = false;
        }
        for(int i = 2;i <= n-1;i++){
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime == true){
            System.out.println("是质数");
        }
        if(isPrime == false){
            System.out.println("不是质数");
        }
    }
}
