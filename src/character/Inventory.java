package character;
import java.util.*;
import objects.InteractiveItem;
/**
 * @author Cole
 *
 */
public class Inventory {
    private ArrayList<InteractiveItem> items;
    
    // TODO docs
    public Inventory (ArrayList<InteractiveItem> items) {
        this.items = items;
    }
    
    // TODO docs
    public ArrayList<InteractiveItem> getItems () {
        return items;
    }
    
    public void addItem () {
        //   
    }
}
