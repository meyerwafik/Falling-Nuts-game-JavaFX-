
package fallingobject;



import java.util.Random;
import javafx.scene.Node;
import javafx.scene.image.ImageView;


abstract public class Fallingobjects  {
    private double x;
    private double y;
   
    Random randompos=new Random();
    protected Fallingobjects(double x,double y)
    {
    this.x=x;
    this.y=y;
    }
    
    public void setX(double x){
    this.x=x;
    }
    
    public void setY(double y){
    this.y=y;
    }
    
    public double getX(){
    return this.x;
    } 
    
    public double getY(){
    return this.y;
    }
    
    
}
