package View;

import Main.NewFXMain;
import NutsButtons.NutsButtons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Mode extends Pane{

    public Mode()
    {
        Image backimg=new Image("Import/backarrow.png");
        ImageView backimgv=new ImageView(backimg);
        backimgv.setFitHeight(100);
        backimgv.setFitWidth(100);
        backimgv.setLayoutX(10);
        backimgv.setLayoutY(10);
        backimgv.setOnMouseClicked(e->{
         Stage s= NewFXMain.getPrimaryStage();
         s.setScene(new ViewManager().getmainscene());
        });       
        Image i=new Image("Import/Scrat.png");
        ImageView i1=new ImageView(i);
        i1.setLayoutX(0);
        i1.setLayoutY(0);
i1.setFitHeight(800);
i1.setFitWidth(900);
        this.getChildren().addAll(i1,backimgv);
        
        
    Button bt=new Button("Play");
   bt.setPrefSize(170, 250);
   bt.setLayoutX(160);
   bt.setLayoutY(270);
   bt.setTextFill(Color.WHITE);
   bt.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.ITALIC,20));
   bt.setStyle("-fx-Background-Color:Black;");
 bt.setOnAction(
 e->{
     
     
     
     CirclePane CP = new CirclePane() ;
     getScene().setRoot(CP);
     CP.requestFocus();

 }
 
 
 
 );
   Circle c=new Circle(250, 250,60);
   
   bt.setShape(c);
   
   Button bt1=new Button("Help");
     bt1.setPrefSize(170, 250);
   bt1.setLayoutX(550);
   bt1.setLayoutY(264);
   bt1.setTextFill(Color.WHITE);
   
    bt1.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.ITALIC,20));
    bt1.setOnAction(e->{
    Stage s= NewFXMain.getPrimaryStage();
         s.setScene(help2());
    });
    
    Circle c1=new Circle(250, 250,60);
   
   bt1.setStyle("-fx-Background-Color:Black");
  bt1.setShape(c1);
 
  
  
  this.getChildren().addAll(bt,bt1);
   
   
    }
    
    public Scene help2(){
    Pane p=new Pane();
    p.setPrefSize(900, 800);
    Image background =new Image("Import/trees.jpg");
    ImageView backgroundiv=new ImageView(background);
    backgroundiv.setFitWidth(900);
    backgroundiv.setFitHeight(800);
    p.getChildren().add(backgroundiv);
    VBox vb=new VBox();
    vb.setAlignment(Pos.CENTER);
    Text player1=new Text("Player1:\n-Right Arrow:Move right\n-Left Arrow:Move left\n-Space bar:shoot");
    Text player2=new Text("Player2:\n-A button:Move left\n-D button:Move right\n-W button:shoot");
    player1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
    player1.setFill(javafx.scene.paint.Color.WHITE);
    player2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));
    player2.setFill(javafx.scene.paint.Color.WHITE);
    vb.getChildren().addAll(player1,player2);
    vb.setLayoutX(300);
    vb.setLayoutY(200);
    vb.setPadding(new Insets(20,20,20,20));
    NutsButtons b=new NutsButtons("back");
       b.setLayoutX(70);
       b.setLayoutY(400);
       b.setPrefSize(200, 200);
       Circle c1=new Circle();
       c1.setRadius(10);
       c1.setFill(javafx.scene.paint.Color.BROWN);
    p.getChildren().addAll(vb,b);
    b.setOnAction(e->{
    Stage s= NewFXMain.getPrimaryStage();
         s.setScene(new ViewManager().play2());
    });
    Scene help2=new Scene(p,900,800);
    return help2;
    }
 
    
}
