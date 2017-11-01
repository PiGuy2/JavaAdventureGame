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
    public void ItemLock(String name, String UNLitem, String type){
        this.name = name;
        this.UNLitem = UNLitem;
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public String getUNLitem(){
        return type;
    }
    public void Unlock(ItemLock meme){
        if (meme.getType() == "item"){
        //scannerboi if the 
        //    == meme.getUNLitem();
        //unlock
        }
    }
}
