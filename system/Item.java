package system;

//Item class template, storing product parameters
public class Item {
public Item(char ID, float price){
	setID(ID);
	setPrice(price);
	setName("sample product "+ID);
}
protected char ID;
private float price;
//for possible product name implementation
private String name;

//mutators/accessors
public char getID(){
	return ID;
}
protected void setID(char ID){
	this.ID = ID;
}
public float getPrice(){
	return price;
}
protected void setPrice(float price){
	this.price = price;
}
public String getName(){
	return name;
}
protected void setName(String name){
	this.name = name;
}


}
