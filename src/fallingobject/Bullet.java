package fallingobject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet extends Circle {
    private double x,y,r;
    public Bullet(double x,double y){
    this.r=10;
    setCenterX(x);
    setCenterY(y);
    setRadius(r);
        setFill(Color.GREEN);
    }
    
    public void moveupwards(){
    this.setCenterY(getCenterY()-10);
    }   
}
