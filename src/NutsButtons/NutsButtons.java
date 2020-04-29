
package NutsButtons;

import javafx.scene.control.Button;
import javafx.scene.text.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;


public class NutsButtons extends Button {
    private final String fontnuts="src/Import/FEASFBI_.TTF"; 
    public NutsButtons(String text){
        setText(text);
        setButtonFont();
         setOnMouseEntered((MouseEvent event) -> {
         setEffect(new DropShadow());
    });
        setOnMouseExited((MouseEvent event) -> {
            setEffect(null);
        });
        
        setStyle("-fx-background-color:#ffffff;" ); 
    }
    
    public void setButtonFont(){
    try {
        setFont(Font.loadFont(new FileInputStream(fontnuts),20));
    } catch(FileNotFoundException e){
        setFont(Font.font("Verdana",23));
    }
    }
    
    
    
    
}
