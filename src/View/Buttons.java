
package View;


import Main.NewFXMain;
import NutsButtons.NutsButtons;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Buttons {
    VBox vb1;
    public Buttons(Pane p,AnimationTimer at,AudioClip media)
    {
        
  Image img2=new Image("Import/pause.png");
  Image play = new Image ("Import/play.png");
  
    ImageView img3=new ImageView(img2);
    ImageView play1=new ImageView(play);
    img3.setLayoutX(400);
        img3.setLayoutY(66);
    img3.setFitHeight(50);
    img3.setFitWidth(50);
     play1.setLayoutX(400);
        play1.setLayoutY(10);
    play1.setFitHeight(50);
    play1.setFitWidth(50);
    play1.setVisible(false);
        p.getChildren().add(img3);
    img3.setOnMouseClicked(e->{
        if (img2 == img3.getImage())
        {
            at.stop();
            img3.setImage(play);
            vb1=new VBox();
            
            vb1.setLayoutX(360);
            vb1.setLayoutY(120);
            vb1.setSpacing(80);
            NutsButtons resume=new NutsButtons("Resume");
            resume.setOnMouseClicked(er->{
            p.getChildren().remove(vb1);
            img3.setImage(img2);
            p.requestFocus();
            at.start();
            });
            resume.setPrefSize(250, 150);
            NutsButtons playagain=new NutsButtons("Play Again");
            playagain.setPrefSize(250, 150);
            playagain.setOnAction(epa->{
            Stage s= NewFXMain.getPrimaryStage();
                try {
                    at.stop();
                    media.stop();
                    s.setScene(new ViewManager().play1());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Buttons.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            });
            NutsButtons exit=new NutsButtons("Exit");
            
            exit.setPrefSize(250, 150);
            exit.setOnAction(ee->{
            Stage s= NewFXMain.getPrimaryStage();
         s.setScene(new ViewManager().getmainscene());
         media.stop();
         at.stop();
            });
            vb1.getChildren().addAll(resume,playagain,exit);
            p.getChildren().add(vb1);
        }
        else if (play== img3.getImage())
        {
            at.start();
            img3.setImage(img2);
            p.getChildren().remove(vb1);
        }
    });
    }
    
    public void pause(AnimationTimer at){
    at.stop();
    }
    
}
