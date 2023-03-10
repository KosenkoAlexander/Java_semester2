import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.UnsupportedOperationException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Group g=new Group();
        g.getStudents().add(new Student("Oleksiy"));
        g.getStudents().add(new Student("Oleksander"));
        g.getStudents().add(new Student("Artem"));
        Random r=new Random();
        for (Student s:g.getStudents()){
            for(int i=0; i<3; i++) {
                s.getMarks().add((int) (r.nextInt(0, 11)));
            }
        }
        for (Student s:g.getStudents()){
            System.out.println(s);
        }
        g.finishYear();
        for(Student s:g.getStudents()){
            try{
                s.getMarks().add(r.nextInt(0,11));
            }catch (UnsupportedOperationException e){
                System.out.println("UnsupportedOperationException was thrown while adding a mark");
            }
        }
        try{
            g.getStudents().add(new Student("Anton"));
        }catch (UnsupportedOperationException e){
            System.out.println("UnsupportedOperationException was thrown while adding a student");
        }
    }
}
class Student{
    public final String name;
    private List<Integer> marks=new ArrayList<>();
    public Student(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public List<Integer> getMarks(){
        return marks;
    }
    public void finishYear(){
        marks=Collections.unmodifiableList(marks);
    }
    public String toString(){
        String s = name+"\n";
        for(int i:marks){
            s+=i+" ";
        }
        return s;
    }
}
class Group{
    private List<Student> students= new ArrayList<>();
    public List<Student> getStudents() {
        return students;
    }
    public void finishYear(){
        students=Collections.unmodifiableList(students);
        for(Student s:students){
            s.finishYear();
        }
    }
}