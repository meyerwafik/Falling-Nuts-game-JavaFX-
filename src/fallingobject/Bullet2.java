package fallingobject;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet2 extends Circle {
    private double x,y,r;
    public Bullet2 (double x,double y){
    this.r=10;
    setCenterX(x);
    setCenterY(y);
    setRadius(r);
        setFill(Color.BROWN);
    }
    public void  movedownwards(){
    this.setCenterY(getCenterY()+10);
    }
}
