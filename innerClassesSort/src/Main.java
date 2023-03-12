import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> arr=new ArrayList<>();
        arr.add(new Person("Andrii", "Ukraine", 1970, true));
        arr.add(new Person("Anastasia", "Ukraine", 1980, false));
        arr.add(new Person("Oleksandr", "Poland", 1971, true));
        arr.add(new Person("Anna", "England", 1969, false));
        arr.add(new Person("Tom", "England", 1988, true));
        arr.add(new Person("Lee", "Korea", 1982, true));
        for(Person p:arr){
            System.out.println(p);
        }
        System.out.println("insert string");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        arr.sort(switch (s){
            case "1" -> new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    int result=o1.getRegion().compareTo(o2.getRegion());
                    if(result!=0){
                        return result;
                    }
                    result=o1.getName().compareTo(o2.getName());
                    if(result!=0){
                        return result;
                    }
                    result=(o1.getIsMale()?1:0)-(o2.getIsMale()?1:0);
                    if(result!=0){
                        return result;
                    }
                    return o1.getBirthYear()-o2.getBirthYear();
                }
            };
            case "2" -> new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    int result=o1.getBirthYear()-o2.getBirthYear();
                    if(result!=0){
                        return result;
                    }
                    result=(o1.getIsMale()?1:0)-(o2.getIsMale()?1:0);
                    if(result!=0){
                        return result;
                    }
                    result=o1.getName().compareTo(o2.getName());
                    if(result!=0){
                        return result;
                    }
                    return o1.getRegion().compareTo(o2.getRegion());
                }
            };
            case "3" -> new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    int result=(o1.getIsMale()?1:0)-(o2.getIsMale()?1:0);
                    if(result!=0){
                        return result;
                    }
                    result=o1.getName().compareTo(o2.getName());
                    if(result!=0){
                        return result;
                    }
                    result=o1.getRegion().compareTo(o2.getRegion());
                    if(result!=0){
                        return result;
                    }
                    return o1.getBirthYear()-o2.getBirthYear();
                }
            };
            default -> new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    int result=o1.getName().compareTo(o2.getName());
                    if(result!=0){
                        return result;
                    }
                    result=o1.getRegion().compareTo(o2.getRegion());
                    if(result!=0){
                        return result;
                    }
                    result=o1.getBirthYear()-o2.getBirthYear();
                    if(result!=0){
                        return result;
                    }
                    return (o1.getIsMale()?1:0)-(o2.getIsMale()?1:0);
                }
            };
        });
        for(Person p:arr){
            System.out.println(p);
        }
    }
}
class Person{
    private String name;
    private String region;
    private int birthYear;
    private boolean isMale;
    public String getName() {
        return name;
    }
    public String getRegion() {
        return region;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public boolean getIsMale() {
        return isMale;
    }
    public Person(String name, String region, int birthYear, boolean isMale){
        this.name=name;
        this.region=region;
        this.birthYear=birthYear;
        this.isMale=isMale;
    }
    public String toString(){
        return name+" "+region+" "+birthYear+" "+(isMale?"male":"female");
    }
}