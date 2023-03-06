public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class ControllerAndView{
    public static void printCharLine(int x, int y, int length, char character){

    }
}
class Rectangle{
    final int width;
    final int height;
    final int x;
    final int y;
    public Rectangle(int width, int height, int x, int y){
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
enum Edges{
    leftDown,
    leftUp,
    rightDown,
    rightUp
}
class Triangle extends Rectangle{
    final Edges edges;
    public Triangle(int width, int height, int x, int y, Edges edges){
        super(width, height, x, y);
        this.edges=edges;
    }
}
abstract class horizontalCombine{
    final int width1;
    final int width2;
    final int width3;
    final int height;
    horizontalCombine(int width1, int width2, int width3, int height){
        this.height=height;
        this.width1=width1;
        this.width2=width2;
        this.width3=width3;
    }
    public int getWidth1() {
        return width1;
    }

    public int getWidth2() {
        return width2;
    }

    public int getWidth3() {
        return width3;
    }

    public int getHeight() {
        return height;
    }
}
abstract class verticalCombine{
    final int height1;
    final int height2;
    final int height3;
    final int width;
    verticalCombine(int height1, int height2, int height3, int width){
        this.height1=height1;
        this.height2=height2;
        this.height3=height3;
        this.width=width;
    }

    public int getHeight1() {
        return height1;
    }

    public int getHeight2() {
        return height2;
    }

    public int getHeight3() {
        return height3;
    }
    public int getWidth(){
        return width;
    }
}
class horizontalTrapezoid extends horizontalCombine{
    final boolean up;
    public horizontalTrapezoid(int width1, int width2, int width3, int height, boolean up){
        super(width1, width2, width3, height);
        this.up=up;
    }
}
class horizontalParallelogram extends horizontalCombine{
    final boolean leftUp;
    public horizontalParallelogram(int width1, int width2, int width3, int height, boolean leftUp){
        super(width1, width2, width3, height);
        this.leftUp=leftUp;
    }
}
class verticalTrapezoid extends verticalCombine{
    final boolean left;
    public verticalTrapezoid(int height1, int height2, int height3, int width, boolean left){
        super(height1, height2, height3, width);
        this.left=left;
    }
}
class verticalParallelogram extends verticalCombine{
    final boolean leftUp;
    public verticalParallelogram(int height1, int height2, int height3, int width, boolean leftUp){
        super(height1, height2, height3, width);
        this.leftUp=leftUp;
    }
}