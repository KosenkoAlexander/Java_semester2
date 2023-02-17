public class IntersectionExplorer { // controller
    public static IntersectionType FindIntersectionType(Rectangle rectangle1, Rectangle rectangle2){
        if(rectangle1.getAx()==rectangle2.getBx()||rectangle2.getAx()==rectangle1.getBx()){
            if (rectangle1.getAy()==rectangle2.getBy()||rectangle2.getAy()==rectangle1.getBy()){
                return IntersectionType.Point;
            }
            else {
                return IntersectionType.HorizontalLine;
            }
        } else if (rectangle1.getAy()==rectangle2.getBy()||rectangle2.getAy()==rectangle1.getBy()) {
            return IntersectionType.VerticalLine;
        } else if (rectangle1.getBx()<rectangle2.getAx()||rectangle1.getAx()>rectangle2.getBx()||rectangle1.getBy()<rectangle2.getAy()||rectangle1.getAy()>rectangle2.getBy()){
            return IntersectionType.None;
        } else {
            return IntersectionType.Rectangle;
        }
    }
}
