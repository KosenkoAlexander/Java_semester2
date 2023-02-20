public class Main {//dispatcher
    public static void main(String[] args){
        Driver driver=new Driver(new Car());
        System.out.println("Completely new car:");
        CarPrinter.printCar(driver.car);
        driver.car.destroy(60);
        System.out.println("After some accident:");
        CarPrinter.printCar(driver.car);
        driver.tryRepair();
        System.out.println("Driver tries fixing:");
        CarPrinter.printCar(driver.car);
        AutoserviceStation.repair(driver);
        System.out.println("After autoservice:");
        CarPrinter.printCar(driver.car);
    }
}
class CarPrinter{//view
    static void printCar(Car car){
        System.out.println("car is "+car.getNeedsRepairPercent()+" % broken");
    }
}
class Car{//model
    private int needsRepairPercent=0;
    public void fix(int percent){
        if(percent<0)return;
        needsRepairPercent-=percent;
        if(needsRepairPercent<0){
            needsRepairPercent=0;
        }
    }
    public void destroy(int percent){
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
    public void tryRepair(){
        car.fix(5);
    }
}
class AutoserviceStation{//controller
    public static void repair(Driver driver){
        driver.car.fix(50);
    }
}