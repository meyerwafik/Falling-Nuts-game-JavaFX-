package View;
import javafx.scene.input.KeyCode;
public class Keymanager {
private boolean []keystates;
public Keymanager(){
keystates=new boolean[4];
}

private int keycodetoindx(KeyCode k){
switch(k){
    case RIGHT:
        return 0;
    case LEFT:
        return 1;

    case A: return 2;
    case D:
        return 3;
   
    default: return -1;
}
}

public void setKeystate(KeyCode k,boolean state){
int i = keycodetoindx(k);
    if (i>=0 && i<4) {
        keystates[i]=state;
    }

}

public boolean getKeystates(KeyCode k){
int i = keycodetoindx(k);
    if (i>=0 && i<4) {
        return keystates[i];
    }
    else return false;
}

}
