import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phones=new ArrayList<>();
        phones.add(new Phone("p1"));
        phones.add(new Phone("p2"));
        phones.add(new Phone("s1"){
            private Smartphone s=new Smartphone(this.getName());
            public void process(){
                s.process();
            }
        });
        ArrayList<Computer> computes=new ArrayList<>();
        computes.add(new Computer("c1"));
        computes.add(new Computer("c2"));
        computes.add(new Computer("s2"){
            private Smartphone s=new Smartphone(this.getName());
            public void process(){
                s.process();
            }
        });
        phones.forEach(p->p.process());
        computes.forEach(c->c.process());
    }
}

class Phone{
    private String name;
    public String getName(){
        return name;
    }
    public Phone(String name){
        this.name=name;
    }
    public void process(){
        System.out.println(name+" setting network...");
    }
}
class Computer{
    private String name;
    public String getName(){
        return name;
    }
    public Computer(String name){
        this.name=name;
    }
    public void process(){
        System.out.println(name+" activating OS...");
    }
}
class Smartphone{
    private final Phone super1;
    private final Computer super2;
    public Smartphone(String name){
        super1=new Phone(name);
        super2=new Computer(name);
    }
    public void process(){
        super1.process();
        super2.process();
    }
}