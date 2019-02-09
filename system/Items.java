package system;



import java.util.TreeMap;

//class to store different item objects - basically simple store database template
public class Items {
Items(){
	
}
protected TreeMap<Character, Item> items = new TreeMap<Character, Item>();

void addItem(Item item){
	items.put(item.ID, item);
}
void removeItem(char key){
	items.remove(key);
}
}
