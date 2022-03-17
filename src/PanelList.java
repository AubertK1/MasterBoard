import java.util.LinkedList;

public class PanelList<M> extends LinkedList {
    int currentIndex=0;
    public M getCurrentPanel (){
        return (M) this.get(currentIndex);
    }

}
