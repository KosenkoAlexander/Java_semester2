import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Smartphone s=new Smartphone();
        Smartphone.super1.process();
    }
}

class Phone{
    public void process(){
        System.out.println("setting network...");
    }
}
class Computer{
    public void process(){
        System.out.println("activating OS...");
    }
}
class Smartphone{
    class super1 extends Phone{}
    private Computer super2=new Computer(){};
    public void process(){
        super1.process();
        super2.process();
    }
}