import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles=new ArrayList<Rectangle>();
        rectangles.add(new Rectangle(2,2,4,4));
        rectangles.add(new Rectangle(1,1,10,10));
        rectangles.add(new Rectangle(40,40,50,50));
        for(int i=0; i<rectangles.size(); i++){
            for(int j=i+1; j<rectangles.size(); j++){
                System.out.println("rectangles "+i+" and "+j);
                IntersectionPrinter.Print(IntersectionExplorer.FindIntersectionType(rectangles.get(i), rectangles.get(j)));
            }
        }
    }
}