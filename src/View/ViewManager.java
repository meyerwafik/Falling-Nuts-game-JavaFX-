package View;


import Main.NewFXMain;
import NutsButtons.NutsButtons;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ViewManager {
    private static final int length=800;
    private static final int width=900;
    private Scene mainscene;
    private Stage mainstage;
    private BorderPane pane;
    private VBox modes;
    private AnchorPane gamepane;
    private static final String url ="Import/MyPost.png";
    private static final String modesbuttons="Import/Hazelnut.png";
    private static final String nutsshells="images.png";
    private static final String nuts="nuts-06-512.png";
    private ImageView[] nut;
    private ImageView[] shell;
    Random randompositiongenerator;
    
     public ViewManager()
     {
      pane=new BorderPane();
      modes=new VBox();
      mainscene=new Scene(pane,width,length);
      mainstage=new Stage();
      mainstage.setScene(mainscene);
      modes.setAlignment(Pos.CENTER_LEFT);
      gamemodebutton1();
      gamemodebutton2();
      exitbutton();
      pane.setRight(modes);
      createBackground();
      createlogo();
    }
    public void gamemodebutton1(){
    Image i = new Image(modesbuttons);
    NutsButtons nb=new NutsButtons("mode 1");
    nb.setGraphic(new ImageView(i));
     nb.setAlignment(Pos.CENTER);
     modes.getChildren().add(nb);
     nb.setOnMouseClicked(new EventHandler<MouseEvent>
     () {
        @Override
        public void handle(MouseEvent event) {
         Stage s= NewFXMain.getPrimaryStage();
         s.setScene(getMode1());
        }
    });     
    }
    public void gamemodebutton2(){
    Image i = new Image(modesbuttons);
    NutsButtons nb=new NutsButtons("mode 2");
    nb.setGraphic(new ImageView(i));
    nb.setAlignment(Pos.CENTER);
    modes.getChildren().add(nb);
    nb.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                nb.setEffect(new DropShadow());
                
            }
        });
    nb.setOnMouseClicked(new EventHandler<MouseEvent>
     () {
        @Override
        public void handle(MouseEvent event) 
        {
         Stage s= NewFXMain.getPrimaryStage();
         s.setScene(play2());
        }
    });    
    }
    
   public void exitbutton (){
    Image i = new Image(modesbuttons);
    NutsButtons nb=new NutsButtons("Exit");
    nb.setGraphic(new ImageView(i));
     nb.setAlignment(Pos.CENTER);
    modes.getChildren().add(nb);
    nb.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Stage s= NewFXMain.getPrimaryStage();
            s.close();
        }
    } );
   }

public Scene getmainscene(){
return mainscene;
}
    public Stage getMainstage() {
        return mainstage;
    }
    private void createBackground()
    {
        Image img = new Image(url);
BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
pane.setBackground(new Background(bgImg));
    }
    
    
     private void createBackground(Pane p)
    {
        Image img = new Image(url);
BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
p.setBackground(new Background(bgImg));
    }
     
    private void createlogo()
    {
        
        HBox lg = new HBox();
        lg.setAlignment(Pos.BASELINE_RIGHT);
        ImageView logo = new ImageView("Import/logo.png");
        logo.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(new DropShadow());
            }
        });
        logo.setOnMouseExited(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(null);
            }
        });
        
        lg.getChildren().add(logo);
        pane.setTop(lg);      
    } 
    public Scene getMode1(){
        HBox lg = new HBox();
        lg.setAlignment(Pos.BASELINE_RIGHT);
        ImageView logo = new ImageView("Import/logo.png");
        logo.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(new DropShadow());
            }
        });
        logo.setOnMouseExited(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(null);
            }
        });
        lg.getChildren().add(logo);
        Image i = new Image(modesbuttons);
        NutsButtons play=new NutsButtons("Play");
        
        play.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage s= NewFXMain.getPrimaryStage();
                    s.setScene(play1());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ViewManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
        
        play.setGraphic(new ImageView(i));
        
        NutsButtons help=new NutsButtons("Help");
        help.setGraphic(new ImageView(i));
        help.setOnMouseClicked(e->{
        Stage s= NewFXMain.getPrimaryStage();
         s.setScene(help1());
        
        });
        NutsButtons back=new NutsButtons("Back");
        back.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Stage s= NewFXMain.getPrimaryStage();
                s.setScene(mainscene);
            }
        
        });
        
        back.setGraphic(new ImageView(i));
    BorderPane p1=new BorderPane();
    VBox vb = new VBox();
    vb.setAlignment(Pos.CENTER);
    vb.getChildren().addAll(play,help,back);
    p1.setRight(vb);
    p1.setTop(lg);
        Scene s1=new Scene(p1,width,length);
        //background
        Image img = new Image(url);
BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
p1.setBackground(new Background(bgImg));
        return s1;
    }
    
     public Scene getMode2(){
        Image i = new Image(modesbuttons);
        NutsButtons play=new NutsButtons("Play");
        
        play.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {

                Stage s= NewFXMain.getPrimaryStage();
                s.setScene(play2());
            }
        
        });
        
        play.setGraphic(new ImageView(i));
        NutsButtons leaderboard=new NutsButtons("leaderboard");
        leaderboard.setGraphic(new ImageView(i));
        NutsButtons help=new NutsButtons("Help");
        help.setGraphic(new ImageView(i));
        help.setOnMouseClicked(e->{
        Stage s= NewFXMain.getPrimaryStage();
         s.setScene(help2());
        });
        
        NutsButtons back=new NutsButtons("Back");
        back.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                Stage s= NewFXMain.getPrimaryStage();
                s.setScene(mainscene);
            }
        });
        
        back.setGraphic(new ImageView(i));
    BorderPane p1=new BorderPane();
    VBox vb = new VBox();
    vb.setAlignment(Pos.CENTER);
    vb.getChildren().addAll(play,leaderboard,help,back);
    p1.setRight(vb);
        Scene s1=new Scene(p1,width,length);
        //background
        Image img = new Image(url);
BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
p1.setBackground(new Background(bgImg));
        return s1;
    }
     
   public Scene play1() throws FileNotFoundException{
   SquirrelPane sqp=new SquirrelPane();
   Scene s1=new Scene(sqp,width,length);
   sqp.requestFocus();
   return s1;
   }
   
   public SubScene ss1(){
       HBox hb1=new HBox();
       Image squirrel1=new Image("Import/Squirrel1.png");
       
   SubScene ss=new SubScene(hb1,400,400);
   return ss;
   }
    public Scene help1(){
       Pane p=new Pane();
       NutsButtons b=new NutsButtons("back");
       b.setLayoutX(70);
       b.setLayoutY(400);
       Circle c1=new Circle();
       c1.setRadius(10);
       c1.setFill(javafx.scene.paint.Color.BROWN);
       
       BorderPane bp=new BorderPane();
       bp.setLeft(b);
       b.setPrefSize(100, 100);
       b.setTextFill(javafx.scene.paint.Color.BROWN);
       b.setOnMouseClicked(e->{
           Stage s= NewFXMain.getPrimaryStage();
         s.setScene(getMode1());
       });
       
       Image back=new Image("Import/background.jpg");
       ImageView background =new ImageView(back);
       p.getChildren().addAll(background,bp); 
       Text t=new Text();
       
       t.setText("-The objective of this mode is to get as many points as possible before turning into roasted squirrel. \n-Bombs reduces the lives by 3. \n-Nuts are points. \n- Shells reduces one life. \n-Glowing Stars increase your lives.\n-You must not eat sweets(cupcakes) or you will get fat."
               + "\n-Level 1 contains only powerups,nuts and shells.\n-Level 2 adds bombs.\n-Level 3 adds cupcakes.");
       
       t.setTextAlignment(TextAlignment.JUSTIFY);
       BorderPane.setAlignment(t, Pos.CENTER);
       t.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
       t.setFill(javafx.scene.paint.Color.BROWN);
       bp.setPadding(new Insets(50, 20, 20, 20));
       t.setLineSpacing(5);
       t.setWrappingWidth(520);
       p.getChildren().addAll(t,b);
       t.setLayoutX(300);
       t.setLayoutY(50);
       Scene h1=new Scene(p,width,length);
       
       Image bi=new Image("Import/Bomb.gif");
       ImageView biv=new ImageView(bi);
       Text tb=new Text("Bomb");
       tb.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
       tb.setFill(javafx.scene.paint.Color.BROWN);
      tb.setLayoutX(150);
       tb.setLayoutY(600);
      
       biv.setLayoutX(140);
       biv.setLayoutY(600);
       p.getChildren().addAll(biv,tb);
       Image n1=new Image("Import/Hazelnut.png");
       ImageView n1v=new ImageView(n1);
       Text tn=new Text("Nuts");
       tn.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
       tn.setFill(javafx.scene.paint.Color.BROWN);
       tn.setLayoutX(310);
       tn.setLayoutY(600);
       n1v.setLayoutX(295);
       n1v.setLayoutY(640);
       p.getChildren().addAll(n1v,tn);
       Image s1=new Image("Import/Shell.png");
       ImageView s1v=new ImageView(s1);
       Text ts=new Text("Shell");
       ts.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
       ts.setFill(javafx.scene.paint.Color.BROWN);
       ts.setLayoutX(460);
       ts.setLayoutY(600);
       s1v.setFitHeight(100);
       s1v.setFitWidth(100);
       s1v.setLayoutX(455);
       s1v.setLayoutY(660);
       p.getChildren().addAll(s1v,ts);
       Image p1=new Image("Import/powerup.gif");
       ImageView p1v=new ImageView(p1);
       Text tp=new Text("Power up");
       tp.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
       tp.setFill(javafx.scene.paint.Color.BROWN);
       tp.setLayoutX(570);
       tp.setLayoutY(600);
       p1v.setFitHeight(100);
       p1v.setFitWidth(100);
       p1v.setLayoutX(590);
       p1v.setLayoutY(680);
       Image eimg=new Image("Import/cupcake.png");
       ImageView eimgv=new ImageView(eimg);
       eimgv.setLayoutX(740);
       eimgv.setLayoutY(680);
       eimgv.setFitHeight(70);
       eimgv.setFitWidth(70);
       Text te=new Text("Cupcake");
       te.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
       te.setFill(javafx.scene.paint.Color.BROWN);
       te.setLayoutX(740);
       te.setLayoutY(600);
       
       p.getChildren().addAll(p1v,tp,eimgv,te);
       
       
       return h1;
   }
    
    
   public Scene help2(){
       StackPane sp=new StackPane();
       NutsButtons b=new NutsButtons("back");
       Circle c1=new Circle();
       c1.setRadius(10);
       c1.setFill(javafx.scene.paint.Color.BROWN);
       
       BorderPane bp=new BorderPane();
       bp.setLeft(b);
       b.setPrefSize(100, 100);
       b.setTextFill(javafx.scene.paint.Color.BROWN);
       b.setOnMouseClicked(e->{
//       mainstage.setScene(getMode2());
           Stage s= NewFXMain.getPrimaryStage();
         s.setScene(getMode2());
       });
       
       Image back=new Image("Import/background.jpg");
       ImageView background =new ImageView(back);
       sp.getChildren().addAll(background,bp); 
       Text t=new Text();
       t.setText("-This is survival of the fittest.");
       t.setTextAlignment(TextAlignment.CENTER);
       BorderPane.setAlignment(t, Pos.CENTER);
       t.setFont(Font.font("Verdana",24));
       t.setFill(javafx.scene.paint.Color.BROWN);
       t.setLineSpacing(5);
       t.setWrappingWidth(520);
       bp.setTop(t);
       Scene h1=new Scene(sp,width,length);
       return h1;
   }
   
   public Scene play2(){
   Mode m=new Mode();
   Scene s2=new Scene(m,900,800);
   return s2;
   }
}
