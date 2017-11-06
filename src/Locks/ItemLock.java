package Locks;
import character.Inventory;
import java.util.*;
import objects.InteractiveItem;
/**
 * Write a description of class ItemLock here.
 *
 * @author Cole
 */

public class ItemLock {
    public String name;
    public String UNLitem;
    public String type;
    public boolean locked;
    public ArrayList<InteractiveItem> items;
    public void ItemLock(String name, String UNLitem, boolean locked, ArrayList<InteractiveItem> items) {
        this.name = name;
        this.UNLitem = UNLitem;
        this.locked = locked;
        this.items = items;
    }

    public String getName(){
        return name;
    }

    public String getUNLitem(){
        return UNLitem;
    }

    public boolean getlocked(){
        return locked;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUNLitem(String UNLitem){
        this.UNLitem = UNLitem;
    }

    public void setlocked(boolean locked){
        this.locked = locked;
    }

    public void Unlock(ItemLock lock){

        if (items.contains(lock.getUNLitem())){
            lock.setlocked(false);
            System.out.println("Good one pal, it's unlocked");
        }

    }
}
