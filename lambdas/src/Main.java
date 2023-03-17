import java.util.Arrays;
import java.util.Random;
import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) {
        Random r=new Random();
        int[] array=new int[10];
        for(int i=0; i<array.length; i++){
            array[i]= r.nextInt(-10,10);
        }
        printIntArr(array);
        System.out.println("negative-positive");
        splitAndPrint(array, i->i<0);
        System.out.println("even-odd");
        splitAndPrint(array, i->i%2==0);
    }
    public static void splitAndPrint(int[] array, IntPredicate predicate){
        int[] negativeArray = Arrays.stream(array).filter(predicate).toArray();
        printIntArr(negativeArray);
        int[] positiveArray = Arrays.stream(array).filter(predicate.negate()).toArray();
        printIntArr(positiveArray);
        double mean1=mean(negativeArray);
        System.out.println("mean 1 :"+mean1);
        double mean2=mean(positiveArray);
        System.out.println("mean 2 :"+mean2);
        int[] between=Arrays.stream(array).filter(i->i>=Math.min(mean1,mean2)&&i<=Math.max(mean1,mean2)).toArray();
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
