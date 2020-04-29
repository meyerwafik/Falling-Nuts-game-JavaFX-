package View;

import Main.NewFXMain;
import NutsButtons.NutsButtons;
import fallingobject.Bullet;
import fallingobject.Bullet2;
import java.io.File;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CirclePane extends Pane {

private Image him;
private ImageView himV;
private Image him1;
private ImageView himV1;
private Bullet b1;
private Keymanager km;
private AudioClip audioplay;

 private Media media;
private HBox h1;
private HBox h2;
private Bullet b;
private Bullet2 b2;
private AnimationTimer at;
        
public CirclePane(){
    this.requestFocus();
h1=new HBox();
    h1.setPadding(new Insets(30,0,0,500));
    h1.setSpacing(0);
    
    
     h2=new HBox();
    h2.setPadding(new Insets(30,0,0,30));
    h2.setSpacing(0);
   
    Image v = new Image("Import/trees.jpg" );
     ImageView   o = new ImageView(v);
       o.setLayoutX(0);
        o.setLayoutY(0);
o.setFitHeight(900);
o.setFitWidth(900);
     this.getChildren().add(o);

     for (int i = 0; i < 12; i++) {
        h1.getChildren().add(new Circle(10,Color.BROWN));
        h2.getChildren().add(new Circle(10,Color.GREEN));
    }
     
     this.getChildren().addAll(h1,h2);
     Label l1=new Label("Health");
    l1.setPadding(new Insets(10,0,0,500));
    l1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
    l1.setStyle("-fx-Background:RED;");
    this.getChildren().add(l1);
    
    Label l2=new Label("Health");
    l2.setPadding(new Insets(10,15,20,25));
    l2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
    l2.setStyle("-fx-Background:RED;");
    this.getChildren().add(l2);
    
     him = new Image("Import/girlsquirrel.png");
        himV = new ImageView(him);
        himV.setLayoutX(400);
        himV.setLayoutY(670);
himV.setFitHeight(125);
himV.setFitWidth(125);
        this.getChildren().add(himV);
    
         
      him1 = new Image("Import/squirrel1_1.png");
        himV1 = new ImageView(him1);
        himV1.setLayoutX(60);
        himV1.setLayoutY(40);
himV1.setFitHeight(125);
himV1.setFitWidth(125);
        this.getChildren().add(himV1);
        
      
        
         km = new Keymanager();
        this.setOnKeyPressed(
                e ->
                {
                    km.setKeystate(e.getCode(), true);
                    if (e.getCode()==KeyCode.SPACE) {
                         if((!(h1.getChildren().isEmpty()))&&(!(h2.getChildren().isEmpty()))){
                            getChildren().add(new Bullet(himV.getLayoutX()+57,himV.getLayoutY()-55));
                           AudioClip shoot = new AudioClip(this.getClass().getResource("shooting.wav").toString());
                            shoot.play();
                         }
   
                   }
                    else if (e.getCode()==KeyCode.W) {
                        if((!(h1.getChildren().isEmpty()))&&(!(h2.getChildren().isEmpty()))){
                        getChildren().add(new Bullet2(himV1.getLayoutX()+56,himV1.getLayoutY()+77));
                         AudioClip shoot = new AudioClip(this.getClass().getResource("shooting.wav").toString());
    
       
                    
                        shoot.play();
                        }
                    }
                }
        );
        this.setOnKeyReleased(
                e ->
                {
                    km.setKeystate(e.getCode(), false);
                }
        );
          
      
 
 
 audioplay=new AudioClip(this.getClass().getResource("backmusic.mp3").toString());
audioplay.setCycleCount(INDEFINITE);

   
   audioplay.play();
    
        at=new AnimationTimer(){

    @Override
    public void handle(long now) {
        
        if(km.getKeystates(KeyCode.RIGHT))  
                      {if(himV.getLayoutX()!=800)
                          himV.setLayoutX((himV.getLayoutX() + 5));    
                      }
                        
                        if(km.getKeystates(KeyCode.LEFT))  
                        {if(himV.getLayoutX()!=10)
                          himV.setLayoutX((himV.getLayoutX() - 5));    
                        }
                                 
                        if(km.getKeystates(KeyCode.D))
                       {
                         if(himV1.getLayoutX()!=770)
                         himV1.setLayoutX((himV1.getLayoutX() + 5)); 
                       }
                                 
                                if(km.getKeystates(KeyCode.A))
                             {
                             if(himV1.getLayoutX()!=10)
                            himV1.setLayoutX((himV1.getLayoutX() - 5)); 
                             }   

        for (Node n : getChildren() ) {
            if(n instanceof Bullet){
        ((Bullet)n).moveupwards();
        if(n.getBoundsInParent().intersects(himV1.getBoundsInParent())){
        AudioClip hit = new AudioClip(this.getClass().getResource("punch.mp3").toString());
    
       
        hit.play();
        h1.getChildren().remove(0);
        n.setLayoutY(-1000);
        }
        }
                if(n instanceof Bullet2){
        ((Bullet2)n).movedownwards();
        if(n.getBoundsInParent().intersects(himV.getBoundsInParent())){
        AudioClip hit = new AudioClip(this.getClass().getResource("punch.mp3").toString());
    
        hit.play();
        h2.getChildren().remove(0);
        n.setLayoutY(2000);
        
        }
        }
        }
        
        if(h2.getChildren().isEmpty())
                              {
                                  getChildren().remove(himV);                              
                                 at.stop();
                                 Image dab2=new Image("Import/dab.jpg");
                                  ImageView dab3=new ImageView(dab2);
                                   
                                  dab3.setFitHeight(800);
                                    dab3.setFitWidth(900);
                                  
                                     Label l3=new Label(" Red Squirrel won ");
                                  l3.setFont(Font.font("Verdana", FontWeight.BOLD,45));
                               l3.setLayoutX(130);
                                  l3.setLayoutY(550);
                                  l3.setTextFill(Color.RED);
                              getChildren().addAll(dab3,l3);
                               NutsButtons playagain=new NutsButtons("Play again");
                                playagain.setPrefSize(200,100);
                                playagain.setOnAction(epa->{
                                Stage s= NewFXMain.getPrimaryStage();
                
                                s.setScene(play2());
                                audioplay.stop();
                                at.stop();
                 
            
            });
                               NutsButtons exit=new NutsButtons("Exit");
                               exit.setPrefSize(200, 100);
                               exit.setOnAction(ee->{
                               Stage s= NewFXMain.getPrimaryStage();
                               s.setScene(new ViewManager().getmainscene());
                               audioplay.stop();
                               at.stop();
                               });
                               HBox hb=new HBox();
                               hb.setPadding(new Insets(50,50,50,50));
                               hb.setSpacing(100);
                               hb.getChildren().addAll(playagain,exit);
                               hb.setLayoutX(240);
                               hb.setLayoutY(590);
                               getChildren().add(hb);
                    
                              
                              }
                                
         if(h1.getChildren().isEmpty())
                              {
                                  getChildren().remove(himV1);
                                  at.stop();

                             Image dab=new Image("Import/dab.jpg");
                                  ImageView dab1=new ImageView(dab);
                                   
                                  dab1.setFitHeight(800);
                                    dab1.setFitWidth(900);
                                  
                                  Label l2=new Label(" Green Squirrel  won ");
                                  l2.setFont(Font.font("verdana", FontWeight.BOLD,45));
                               l2.setLayoutX(130);
                                  l2.setLayoutY(550);
                                  l2.setTextFill(Color.GREEN);
                              getChildren().addAll(dab1,l2);
                                NutsButtons playagain=new NutsButtons("Play again");
                                playagain.setPrefSize(200,100);
                                playagain.setOnAction(epa->{
                                Stage s= NewFXMain.getPrimaryStage();
                
                                s.setScene(play2());
                                audioplay.stop();
                                at.stop();
                 
            
            });
                               NutsButtons exit=new NutsButtons("Exit");
                               exit.setPrefSize(200, 100);
                               exit.setOnAction(ee->{
                               Stage s= NewFXMain.getPrimaryStage();
                               s.setScene(new ViewManager().getmainscene());
                               audioplay.stop();
                               at.stop();
                               });
                               HBox hb=new HBox();
                               hb.setPadding(new Insets(50,50,50,50));
                               hb.setSpacing(100);
                               hb.getChildren().addAll(playagain,exit);
                               hb.setLayoutX(240);
                               hb.setLayoutY(590);
                               getChildren().add(hb);
                               
                              }
                                
    }
        
        };
        at.start();
        Buttons2 b =new Buttons2(this,at,audioplay) ;

 Image img=new Image("Import/soundd.png");
    ImageView img1=new ImageView(img);
    img1.setFitHeight(50);
    img1.setFitWidth(50);
    MenuBar mb=new MenuBar();
    mb.setLayoutX(300);
    mb.setLayoutY(7);
    
  mb.setStyle("-fx-Border-Color:null;-fx-Background-Color:null;");
    mb.setShape(new Circle(20));
    Menu m= new Menu();
    m.setGraphic(img1);
    m.setStyle("-fx-Border-Color:null;-fx-Border-width:7;");
    MenuItem mi=new MenuItem("ON");
    MenuItem mi1=new MenuItem("OFF");
     m.getItems().addAll(mi,mi1);
     mb.getMenus().add(m);
   this.getChildren().add(mb); 
    mi1.setOnAction(
  e2->{
      audioplay.stop();
  }
  
  );
   
  
  mi.setOnAction(
  e3->{
      audioplay.play();
      
  }
  
  
  );
    
}
 
public Scene play2(){
CirclePane c=new CirclePane();
Scene s=new Scene(c,900,800);
c.requestFocus();
return s;
}
     
}
