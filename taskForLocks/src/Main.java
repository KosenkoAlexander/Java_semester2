import java.io.*;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        initialGenerator(false, 1000);
        Counter c1=new Counter(new File("numbers0"), "count0");
        Counter c2=new Counter(new File("numbers1"), "count1");
        Counter c3=new Counter(new File("numbers2"), "count2");
        c1.start();
        c2.start();
        c3.start();
        c1.join();
        c2.join();
        c3.join();
        System.out.println("Lock digit sum "+Counter.getCount());
        Counter.reset();
        c1=new Counter(new File("numbers0"), "count1");
        c2=new Counter(new File("numbers1"), "count2");
        c3=new Counter(new File("numbers2"), "count3");
        c1.start();
        c1.join();
        c2.start();
        c2.join();
        c3.start();
        c3.join();
        System.out.println("One at a time test "+Counter.getCount());
    }
    public static void initialGenerator(boolean deleteAfterWork, int len){
        for(int i=0; i<3; i++){
            File file=new File("numbers"+i);
            if(deleteAfterWork)file.deleteOnExit();
            if(!file.exists()){
                Random rnd=new Random();
                FileWriter writer;
                try{
                    file.createNewFile();
                    writer=new FileWriter(file);
                    try{
                        for(int j=0; j<len; j++) {
                            writer.write("" + rnd.nextInt(0, 10));
                        }
                    }finally {
                        writer.close();
                    }
                }catch (IOException e){
                    System.out.println("troubles with files");
                }
            }
        }
    }
}
class Counter extends Thread{
    private static int count=0;
    private int lockcount=1;
    public static int getCount(){
        return count;
    }
    private File file;
    private String name;
    public Counter(File file, String name){
        this.file=file;
        this.name=name;
    }
    private static Lock lock=new ReentrantLock();
    public void run(){
        try{
            FileReader r=new FileReader(file);
            BufferedReader reader=new BufferedReader(r);
            try {
                while (reader.ready()){
                    char c=(char)reader.read();
                    if((Character.isDigit(c))){
                        int digit=Character.digit(c, 10);
                        try {
                            while (!lock.tryLock()) {
                                System.out.println(name + " LOCKED " + lockcount + "th time");
                                lockcount++;
                            }
                            count += digit;
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            }finally {
                r.close();
                reader.close();
            }
        }catch(IOException e){
            System.out.println("IOException");
            e.printStackTrace();
        }
    }
    public static void reset(){
        count=0;
    }
}