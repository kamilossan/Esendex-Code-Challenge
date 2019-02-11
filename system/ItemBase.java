package system;

public class ItemBase extends Items{
	//creating "data" for the system as there is no database to read from
	Item A = new Item('A', 60);
	Item B = new Item('B', 30);
	Item C = new Item('C', 30);
	Item D = new Item('D', 25);
	public void addToBase(){
		addItem(A);
		addItem(B);
		addItem(C);
		addItem(D);
	}
	ItemBase(){
		addToBase();
	}

}
