public class TimesTable {
    public static void main(String args[]){
 /*       int a;
        for(int i = 0;i <= 100;i++){
            if(i % 3 == 0){
                a = i;
                System.out.println(a);
            }
        }
        for(int j = 1;j <= 9;j++){
            for(int i = 1;i <= j;i++){
                System.out.print(j + "*" + i + "=" + (j * i) + " ");
            }
            System.out.println();
        }*/
        for(int i = 5;i >= 1;i--){
            for(int j = 1;j <= i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
