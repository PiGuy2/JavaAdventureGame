package Locks;

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
    public void ItemLock(String name, String UNLitem, String type, boolean locked){
        this.name = name;
        this.UNLitem = UNLitem;
        this.type = type;
        this.locked = locked;
    }
    public String getName(){
        return Name;
    }
    public String getType(){
        return type;
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
    public void setType(String type){
        this.type = type;
    }
    public void setUNLitem(String UNLitem){
        this.UNLitem = UNLitem;
    }
    public void setlocked(boolean locked){
        this.locked = locked;
    }
    public void Unlock(ItemLock lock){
        if (lock.getType() == "item"){
          if (inventory.contains(lock.getUNLitem())){
            lock.setlocked(false);
            System.out.println("Good one pal, it's unlocked");
          }
          if (lock.getType() == "String"){
            
            
            
          }
          if (lock.getType() == "int"){
            
          }
        }
    }
}
