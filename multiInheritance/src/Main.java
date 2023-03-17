import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phones=new ArrayList<>();
        phones.add(new Phone());
        phones.add(new Phone());
        phones.add(new Phone(){
            private Smartphone s=new Smartphone();
            public void process(){
                s.process();
            }
        });
        ArrayList<Computer> computes=new ArrayList<>();
        computes.add(new Computer());
        computes.add(new Computer());
        computes.add(new Computer(){
            private Smartphone s=new Smartphone();
            public void process(){
                s.process();
            }
        });
        phones.forEach(p->p.process());
        computes.forEach(c->c.process());
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
    private final Phone super1=new Phone();
    private final Computer super2=new Computer();
    public void process(){
        super1.process();
        super2.process();
    }
}