import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r=new Random();
        int[] array=new int[10];
        for(int i=0; i<array.length; i++){
            array[i]= r.nextInt(-10,10);
        }
        printIntArr(array);
        int[] negativeArray = Arrays.stream(array).filter(i->i<0).toArray();
        printIntArr(negativeArray);
        int[] positiveArray = Arrays.stream(array).filter(i->i>=0).toArray();//we need to split an array, therefore zeros must go to some part
        printIntArr(positiveArray);
        double nmean=mean(negativeArray);
        System.out.println("negative mean "+nmean);
        double pmean=mean(positiveArray);
        System.out.println("positive mean "+pmean);
        int[] between=Arrays.stream(array).filter(i->i>=nmean&&i<=pmean).toArray();
        printIntArr(between);
    }
    public static void printIntArr(int[] array){
        System.out.print("{ ");
        for(int i=0; i< array.length; i++){
            System.out.print(array[i]);
            if(i< array.length-1)System.out.print(", ");
        }
        System.out.print("}\n");
    }
    public static double mean(int[] array){
        double mean=0;
        for(int i:array){
            mean+=i;
        }
        mean/=array.length;
        return mean;
    }
}
