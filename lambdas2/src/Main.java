import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars=new ArrayList<>();
        Random r=new Random();
        for(int i=0; i<10; i++){
            cars.add(new Car(r.nextInt(50,150)));
        }
        System.out.println("insert speed");
        Scanner s=new Scanner(System.in);
        int speed = s.nextInt();
        ArrayList<Car> slowCars= (ArrayList<Car>) cars.stream().filter(c->c.getMaxSpeed()<speed).collect(Collectors.toList());
        ArrayList<Car> fastCars= (ArrayList<Car>) cars.stream().filter(c->c.getMaxSpeed()>=speed).collect(Collectors.toList());
        printCarArray(cars);
        printCarArray(slowCars);
        printCarArray(fastCars);
    }
    public static void printCarArray(ArrayList<Car> cars){
        System.out.print("{ ");
        for(int i=0; i< cars.size(); i++){
            System.out.print(cars.get(i).getMaxSpeed());
            if(i< cars.size()-1)System.out.print(", ");
        }
        System.out.print("}\n");
    }
}
class Car{
    private int maxSpeed;
    public int getMaxSpeed(){
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed){
        if(maxSpeed>0){
            this.maxSpeed=maxSpeed;
        }
    }
    public Car(int maxSpeed){
        this.maxSpeed=maxSpeed>0?maxSpeed:0;
    }
}