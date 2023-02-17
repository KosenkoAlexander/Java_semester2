public class PrintIntersection {// view
    public static void Print(IntersectionType type){
        System.out.println( switch (type){
            case Point -> "Point";
            case HorizontalLine -> "Horizontal line";
            case VerticalLine -> "Vertical line";
            case Rectangle -> "Rectangle";
            case None -> "None";
        });
    }
}
