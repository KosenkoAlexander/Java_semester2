public class Main {
    public static void main(String[] args) {
        int ax1=1, ay1=1, bx1=2, by1=2, ax2=1, ay2=1, bx2=3, by2=3;
        System.out.print("Перетин: ");
        if(ax1==bx2||ax2==bx1){
            if (ay1==by2||ay2==by1) System.out.println("крапка");
            else System.out.println("горизонтальна пряма");
        } else if (ay1==by2||ay2==by1) {
            if(ax1==bx2||ax2==bx1) System.out.print("крапка");
            System.out.println("вертикальна пряма");
        } else if ((ax1<=ax2&&bx1>=ax2||ax2<=bx1&&bx1>=bx2)&&(ay1<=ay2&&by1>=ay2||ay2<=by1&&by1>=by2)){
            System.out.print("прямокутник");
        } else System.out.print("відсутній");
    }
}