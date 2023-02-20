public class Main {//dispatcher
    public static void main(String[] args){
        Driver driver=new Driver(new Car());
        System.out.println("Completely new car:");
        CarPrinter.PrintCar(driver.car);
        driver.car.Destroy(60);
        System.out.println("After some accident:");
        CarPrinter.PrintCar(driver.car);
        driver.TryRepair();
        System.out.println("Driver tries fixing:");
        CarPrinter.PrintCar(driver.car);
        AutoserviceStation.Repair(driver.car);
        System.out.println("After autoservice:");
        CarPrinter.PrintCar(driver.car);
    }
}
class CarPrinter{//view
    static void PrintCar(Car car){
        System.out.println("car is "+car.getNeedsRepairPercent()+" % broken");
    }
}
class Car{//model
    private int needsRepairPercent=0;
    public void Fix(int percent){
        if(percent<0)return;
        needsRepairPercent-=percent;
        if(needsRepairPercent<0){
            needsRepairPercent=0;
        }
    }
    public void Destroy(int percent){
        if(percent<0)return;
        needsRepairPercent+=percent;
        if(needsRepairPercent>100){
            needsRepairPercent=100;
        }
    }
    public int getNeedsRepairPercent(){
        return needsRepairPercent;
    }
}
class Driver{//model
    Car car;
    public Driver(Car car){
        this.car=car;
    }
    public void TryRepair(){
        car.Fix(5);
    }
}
class AutoserviceStation{//controller
    public static void Repair(Car car){
        car.Fix(50);
    }
}