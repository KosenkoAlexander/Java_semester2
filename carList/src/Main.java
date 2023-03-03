import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars=new ArrayList<>();
        cars.add(new Car("somemodel", "Serg", 50000, 2012));
        cars.add(new Car("somemodel2", "OLeksandr", 50000, 2011));
        cars.add(new Car("somemodel3", "Andrey", 60000, 2013));
        System.out.println("car list contains car with owner Serg (checked with contains()): "+cars.contains(new Owner("Serg")));
        System.out.println("car list contains car with owner Serg (checked with Controller): "+Controller.checkPresence(cars, "Serg"));
    }
}
class Controller{
    public static boolean checkPresence(ArrayList<Car> cars, String owner){
        for(Car car:cars){
            if(car.getOwner().equals(owner))return true;
        }
        return false;
    }
}
class Owner{
    private String name;
    public String getName(){
        return name;
    }
    public boolean equals(Object obj) {
        if(obj instanceof Car){
            return name.equals(((Car)obj).getOwner());
        }
        else return super.equals(obj);
    }
    public Owner(String name){
        this.name=name;
    }
}

class Car{
    private String model;
    private String owner;
    private int price;
    private int produceYear;
    public String getModel() {
        return model;
    }
    public String getOwner() {
        return owner;
    }
    public int getPrice() {
        return price;
    }
    public int getProduceYear() {
        return produceYear;
    }
    public Car(String model, String owner, int price, int produceYear){
        this.owner=owner;
        this.model=model;
        this.produceYear=produceYear;
        this.price=price;
    }
}