package Main;
import View.ViewManager;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class NewFXMain extends Application {
    private static Stage pStage;
    
    @Override
    public void start(Stage primaryStage) {   
        setPrimaryStage(primaryStage);
        pStage=primaryStage;
        pStage.setScene(new ViewManager().getmainscene());
        pStage.setTitle("Falling Nuts");
        pStage.show();
        primaryStage.setResizable(false);
    }
    public static void main(String[] args) {
        
        launch(args);
    }
    public static Stage getPrimaryStage(){
        return pStage;
    }
    private static void setPrimaryStage(Stage pStage)
    {
        NewFXMain.pStage=pStage;
    }
    
}
