package fallingobject;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Enlarge extends Fallingobjects {
    private static final String Image="Import/cupcake.png";
     private ImageView [] sa ;

    
    public Enlarge(double x,double y,Pane p){
    super(x,y);
    createobj(p);
    }


    public void move() {
        for (int i=0 ; i<sa.length ;i++)
        {
            sa[i].setLayoutY(sa[i].getLayoutY()+5);
        }
       
    }
    
    public void createobj(Pane p)
    {
        sa = new ImageView[1];
        for (int i = 0;i<sa.length;i++  )
        {
            sa[i]= new ImageView(Image);
            sa[i].setFitHeight(70);
            sa[i].setFitWidth(70);
            setxy(sa[i]);
            p.getChildren().add(sa[i]);
            
        }
       
        }
   
    public void check(Pane p)
    {
        for (int i =0;i<sa.length;i++)
        {
            if (sa[i].getLayoutY()> p.getHeight())
                setxy(sa[i]);
        }
    }
    public void setxy(ImageView image)
    {
        image.setLayoutX(randompos.nextInt(900));
        image.setLayoutY(-(randompos.nextInt(3200)+600));
    }
    public ImageView getEnlarge(int i)
    {
        return sa[i];
    }

    
    
}
