import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        initialGenerator(false);

    }
    public static void initialGenerator(boolean deleteAfterWork){
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
                        for(int j=0; j<1000; j++) {
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
