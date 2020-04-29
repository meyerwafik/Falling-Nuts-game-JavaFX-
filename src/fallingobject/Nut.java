package fallingobject;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
public class Nut extends Fallingobjects {
 
    private static final String Image="Import/Hazelnut.png";
     private ImageView [] sa ;

    
    public Nut(double x,double y,Pane p){
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
        sa = new ImageView[5];
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
//    private void createloop(Pane p)
//    {
//         AnimationTimer gametimer = new AnimationTimer() {
//             @Override
//             public void handle(long now) {
//                 move();
//                 check(p);
//             }
//         };
//        gametimer.start();
//    }
    public void setxy(ImageView image)
    {
        image.setLayoutX(randompos.nextInt(900));
        image.setLayoutY(-(randompos.nextInt(3200)+600));
    }
    public ImageView getNut(int i)
    {
        return sa[i];
    }
    
}
