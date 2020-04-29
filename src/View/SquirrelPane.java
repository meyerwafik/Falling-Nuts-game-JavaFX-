package View;

import Main.NewFXMain;
import NutsButtons.NutsButtons;
import SquirrelShape.Squirrel;
import View.Buttons;
import View.ViewManager;
import fallingobject.Bomb;
import fallingobject.Enlarge;
import fallingobject.Nut;
import fallingobject.NutsShells;
import fallingobject.Powerup;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author meyer
 */
public class SquirrelPane extends Pane{
    
    private final String fontnuts="Import/FEASFBI_.TTF"; 
    private static final String s ="Import/Hazelnut.png";
    private static final String t ="Import/Squirrel1.png";
    private static final double width = 900;
    private static final double length = 800;
    private static final String nutsshells="images.png";
    private static final String nuts="nuts-06-512.png";
    private ImageView sqiv;
    private Label lb1,lb2;
    Random randompos;
    private AnimationTimer gametimer;
    HBox hhb;
    private static final String background="Import/background.jpg";
    
    final static int Squirrel_raduis=25;
    final static int Nuts_raduis=15;
    final static int Shells_raduis=15;
    static int x =3;
    
   Bomb bm;
   Nut nut;
   Powerup pu;
   Enlarge en;
   NutsShells shells;
   Squirrel sq1;
   Image z;
   Image i;
   Label level ;
   Media media;
   AudioClip audioPlayer;
    
    public SquirrelPane() throws FileNotFoundException{
//      String  path = "src/Import/backmusic.mp3";
//      media= new Media(new File(path).toURI().toString());
//      mediaPlayer = new MediaPlayer(media);
      audioPlayer=new AudioClip(this.getClass().getResource("backmusic.mp3").toString());
      audioPlayer.setVolume(0.4);
      audioPlayer.setCycleCount(INDEFINITE);
      audioPlayer.play();
      level = new Label("Level 1");
        level.setLayoutX(317);
        level.setLayoutY(20);
        level.setFont(Font.font("verdana", FontWeight.BOLD, 35));
        i=new Image("Import/DeadSq.png");       
        z=new Image("Import/health.png");
        createBackground(this);
         getChildren().add(level);
        sq1=new Squirrel(width/2, length-125);
        sqiv=sq1.getImageView();
   hhb= new HBox();
    hhb.getChildren().addAll(new ImageView(z),new ImageView(z),new ImageView(z));
    hhb.setLayoutX(50);
    hhb.setLayoutY(30);
    this.getChildren().add(hhb);

        bm=new Bomb(0,0,this);
        nut=new Nut(0,0,this);
          pu=new Powerup(0,0,this);
          en= new Enlarge(0, 0, this);
          shells=  new NutsShells(0, 0, this);    
           lb2 =new Label("score ="+ sq1.getScore());
        lb2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        lb2.setLayoutX(600);
        lb2.setLayoutY(30);
        getChildren().add(lb2);
        
        sqiv.setLayoutX(sq1.getX());
        sqiv.setLayoutY(sq1.getY());
        getChildren().add(sqiv);
       createloop(this);
       Buttons b=new Buttons(this,gametimer,audioPlayer);
       
       
       Image img=new Image("Import/soundd.png");
    ImageView img1=new ImageView(img);
    img1.setFitHeight(50);
    img1.setFitWidth(50);
    MenuBar mb=new MenuBar();
    mb.setLayoutX(300);
    mb.setLayoutY(60);
    
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
      audioPlayer.stop();
  }
  
  );
   
  
  mi.setOnAction(
  e3->{
      audioPlayer.play();
      
  }
  
  
  );
    
}
       
     private void createBackground(Pane p)
    {
        
        Image img = new Image(background);
        ImageView im = new ImageView(img);
        im.setFitHeight(800);
        im.setFitWidth(900);
        this.getChildren().add(im);
    }
        
 public void collisionBomb (ImageView a ,ImageView b)
 {
     
     if (a.getBoundsInParent().intersects(b.getBoundsInParent()))
     {
        AudioClip bmb = new AudioClip(this.getClass().getResource("bomb.mp3").toString());

      bmb.play();
    
         bm.setxy(b);
          
                    if(!(hhb.getChildren().isEmpty()))
          {
            if (sq1.getLife()>=3)
         
             hhb.getChildren().remove(0,3);
         
         
            else if(sq1.getLife()==2)
            hhb.getChildren().remove(0,2);
             else hhb.getChildren().remove(0);      
          }
             sq1.setLife(sq1.getLife()-3);

        
     }  
 }
 public void collisionPowerUp (ImageView a ,ImageView b)
 {
     if (a.getBoundsInParent().intersects(b.getBoundsInParent())){
        AudioClip PowUp = new AudioClip(this.getClass().getResource("twinkle.mp3").toString());
             PowUp.play();
   
        pu.setxy(b);
        
        if (sq1.getLife()<=5)
        {
        hhb.getChildren().add(new ImageView(z));
        
       sq1.setLife(sq1.getLife()+1);
        }       
     }  
 }
 public void collisionShells (ImageView a ,ImageView b)
 {
    
     if (a.getBoundsInParent().intersects(b.getBoundsInParent())){
      AudioClip hit = new AudioClip(this.getClass().getResource("hit.mp3").toString());
             hit.play();
       if (!(hhb.getChildren().isEmpty()))
           hhb.getChildren().remove(0);
        sq1.setLife(sq1.getLife()-1);
          shells.setxy(b);            
     }  
 }
 public void collisionNut (ImageView a ,ImageView b)
 {
     if (a.getBoundsInParent().intersects(b.getBoundsInParent())){
         AudioClip eat = new AudioClip(this.getClass().getResource("eat.mp3").toString());
             

      eat.play();
         nut.setxy(b);
        sq1.setScore(sq1.getScore()+1);
       
        lb2.setText("score ="+sq1.getScore());
        
     }  
 }
 
 public void collisionEnlarge (ImageView a ,ImageView b)
 {
     if (a.getBoundsInParent().intersects(b.getBoundsInParent())){
       
        en.setxy(b);
         AudioClip En = new AudioClip(this.getClass().getResource("chewing.mp3").toString());
             En.play();
        sqiv.setFitWidth(sqiv.getFitWidth()+20);
        sqiv.setLayoutY(sqiv.getLayoutY()-20);
        sqiv.setFitHeight(sqiv.getFitHeight()+20);       
     }  
 }
 public void createloop(Pane p)
    {
         gametimer = new AnimationTimer() {
             @Override
             public void handle(long now) {
                 
            setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.LEFT){
                if (sqiv.getLayoutX() >=10) {
                sqiv.setLayoutX(sqiv.getLayoutX()-15);    
                }
                }
            else if (event.getCode() == KeyCode.RIGHT){
                if (sqiv.getLayoutX() <= (width-sqiv.getFitWidth())) {
                sqiv.setLayoutX(sqiv.getLayoutX() + 15);    
                }
            }
        });
                  if(sq1.getScore()>=10)
                 {                   
                 level.setText("Level 2");  
                 bm.move();
                 bm.check(p);
                 }
                  if (sq1.getScore()>=20)
                 {
                  level.setText("Level 3");   
                 en.move();
                 en.check(p);
                 }
                 nut.move();
                 nut.check(p);
                 pu.move();
                 pu.check(p);
                 shells.move();
                 shells.check(p);
                 if (sq1.getLife()<0)
                 {
                     gametimer.stop();
                     Label lb = new Label  ("Game Over\n\n  Score="+sq1.getScore());
                     lb.setLayoutX(300);
                     lb.setLayoutY(110);
                     lb.setFont(Font.font("verdana", FontWeight.BOLD, 40));
                    sqiv.setImage(i);
                    p.getChildren().remove(sq1);
                     p.getChildren().add(lb);
                     VBox vb=new VBox();
                     NutsButtons playagain=new NutsButtons("Play again");
                     playagain.setPrefSize(250,150);
                     playagain.setOnAction(e->{
                     gametimer.stop();
                     audioPlayer.stop();
                     Stage s= NewFXMain.getPrimaryStage();
                         try {
                             s.setScene(new ViewManager().play1());
                         } catch (FileNotFoundException ex) {
                             Logger.getLogger(SquirrelPane.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     });
                    NutsButtons exit=new NutsButtons("Exit");
                    exit.setPrefSize(250, 150);
                    exit.setOnAction(e->{
                    gametimer.stop();
                    audioPlayer.stop();
                     Stage s= NewFXMain.getPrimaryStage();
                    s.setScene(new ViewManager().getmainscene());
                    });
                    vb.getChildren().addAll(playagain, exit);
                    vb.setLayoutX(340);
                    vb.setLayoutY(300);
                    vb.setSpacing(50);
                    getChildren().add(vb);
                 }
                 
                       
          for (int i=0;i<3;i++)
        {
            if (sq1.getScore()>=10)
            {
            collisionBomb(sqiv,bm.getBomb(i));
            }
            collisionShells(sqiv, shells.getShells(i));
        }
            for (int i=0;i<5;i++)
        {
            collisionNut(sqiv,nut.getNut(i));
        }
         for (int i=0;i<1;i++)
        {
            collisionPowerUp(sqiv,pu.getPower(i));
            if (sq1.getScore()>=20)
            {
           collisionEnlarge(sqiv,en.getEnlarge(i));
            }
        }
            
          }
         };
        gametimer.start();
    }
}
