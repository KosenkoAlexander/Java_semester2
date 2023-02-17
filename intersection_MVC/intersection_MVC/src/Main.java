public class Main {
    public static void main(String[] args) {
        Rectangle[] rectangles={new Rectangle(2,2,4,4), new Rectangle(1,1,10,10), new Rectangle(40,40,50,50)};
        for(int i=0; i<rectangles.length; i++){
            for(int j=i+1; j<rectangles.length; j++){
                System.out.println("rectangles "+i+" and "+j);
                IntersectionPrinter.Print(IntersectionExplorer.FindIntersectionType(rectangles[i], rectangles[j]));
            }
        }
    }
}