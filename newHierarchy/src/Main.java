public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class Transport{
    private int fuel;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getFuel() {
        return fuel;
    }
}
class Plane extends Transport{
    public void fly(){

    }
}
class Auto extends Transport{

}
class Ship extends Transport{

}
interface PassengerTransport{

}
interface CargoTransport{

}
class PassengerPlane extends Plane implements PassengerTransport{

}
class TransportPlane extends Plane implements CargoTransport{

}
class FighterAircraft extends Plane{

}
class Car extends Auto implements PassengerTransport{

}
class Bus extends Auto implements PassengerTransport{

}
class Truck extends Auto implements CargoTransport{

}
class PassengerLiner extends Ship implements PassengerTransport{

}
class TugShip extends Ship implements CargoTransport{

}
class Tanker extends Ship{

}