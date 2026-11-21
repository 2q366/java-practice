public class Test {
    public static void main(String[] args){
        int score[] = {85, 92, 78, 60, 99};
        int i,sum = 0;
        for(i = 0;i < score.length;i++){
            sum = sum + score[i];
        }
        double avg = sum / 5.0;
        int max = score[0];
        int min = score[0];
        for(int j = 1;j < score.length;j++){
            if(max < score[j]){
                max = score[j];
            }
            if(min > score[j]){
                min = score[j];
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(avg);
        System.out.println(sum);
    }
}
