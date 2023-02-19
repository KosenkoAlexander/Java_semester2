public class Main {//view
    public static void main(String[] args){
        Driver driver=new Driver(new Car());
        System.out.println("Completely new car:\ncar is "+driver.car.getNeedsRepairPercent()+" % broken");
        driver.car.Destroy(60);
        System.out.println("After some accident:\ncar is "+driver.car.getNeedsRepairPercent()+" % broken");
        driver.TryRepair();
        System.out.println("Driver tries fixing:\ncar is "+driver.car.getNeedsRepairPercent()+" % broken");
        AutoserviceStation.Repair(driver.car);
        System.out.println("After autoservice:\ncar is "+driver.car.getNeedsRepairPercent()+" % broken");
    }
}
class Car{
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