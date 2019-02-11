package system;



import java.util.TreeMap;

//class to store different item objects - basically simple store database template
public class Items {
Items(){
	
}
Items(Item[] items){
	addToBase(items);
}
private TreeMap<Character, Item> items = new TreeMap<Character, Item>();

void addItem(Item item){
	items.put(item.getID(), item);
}
void removeItem(char key){
	items.remove(key);
}
//actual function to read items from database should there be one
public void addToBase(Item[] items){
	for(Item item:items){
		addItem(item);
	}
}
TreeMap<Character,Item> getItems(){
	return items;
}
}
