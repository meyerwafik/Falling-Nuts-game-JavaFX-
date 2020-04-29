
package SquirrelShape;


import View.SquirrelPane;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;


public class Squirrel  {
 
private double x;
private double y;
    Image sq1;
    Image z;
    ImageView health;
    ImageView sqiv;
    ArrayList h;
    private static  int life ;
    private static int score ;
    public Squirrel(double x,double y){
    this.x=x;
    this.y=y;
    life = 3;
    score = 0;    
    sq1=new Image("Import/Sq1.png");
    sqiv=new ImageView(sq1);
    sqiv.setFitWidth(120);
    sqiv.setFitHeight(120);
    }
    public ImageView getImageView(){
    sqiv.setLayoutX(getX());
        sqiv.setLayoutY(getY());
        return sqiv;
    }
     
      public void move(SquirrelPane p){
      p.setOnKeyPressed(e->{
          if (e.getCode()==KeyCode.RIGHT) {
              setX(getX()+23);
          }
          else if   (e.getCode()==KeyCode.LEFT){
          setX(getX()-23);
          }
      });
      }  
      public void setLife(int life)
      {
          this.life = life;
      }
      public int getLife()
      {
         return life;
      }
      public void setScore(int score)
      {
          this.score = score;
      }
      public int getScore()
      {
         return score;
      }
     
      public double getX(){
return this.x;
}

public double getY(){
return this.y;
}

public void setX(double x){
this.x=x;
}

public void setY(double y){
this.y=y;
}
     
}
