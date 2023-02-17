public class Rectangle {// model
    private int ax;
    private int bx;
    private int ay;
    private int by;
    public Rectangle(int ax, int ay, int bx, int by){
        this.ax=ax;
        this.ay=ay;
        this.bx=bx;
        this.by=by;
        if(ax>bx||ay>by){
            System.out.println("WARNING: A and B may be on wrong places");
        }
    }
    public int getAx(){
        return ax;
    }
    public int getBx(){
        return bx;
    }
    public int getAy(){
        return ay;
    }
    public int getBy(){
        return by;
    }
}
