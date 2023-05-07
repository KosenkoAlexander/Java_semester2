import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    static Map<Integer, Integer> evenNumbers=new HashMap<>();
    public static void main(String[] args) {
        int n=10000000;
        int[] numbers=new int[n];
        for(int i=0; i<n; i++){
            numbers[i]=(int)(Math.random()*10);
        }

        Stream<Integer> s1= Arrays.stream(numbers).boxed();
        Stream<Integer> s2=Arrays.stream(numbers).boxed().parallel();
        long t1=System.currentTimeMillis();
        s1.forEach(i->{if(i%2==0)addOrCount(i);});
        long t2=System.currentTimeMillis();
        System.out.println(evenNumbers);
        System.out.println("time spent:"+(t2-t1));
        evenNumbers=new HashMap<>();
        t1=System.currentTimeMillis();
        s2.forEach(i->{if(i%2==0)addOrCount(i);});
        t2=System.currentTimeMillis();
        System.out.println(evenNumbers);
        System.out.println("time spent:"+(t2-t1));
    }
    public static synchronized void addOrCount(Integer i){
        evenNumbers.putIfAbsent(i, 0);
        evenNumbers.put(i,evenNumbers.get(i)+1);
    }
}
