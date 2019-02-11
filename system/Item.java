package system;

import java.math.BigDecimal;

//Item class template, storing product parameters
public class Item {

private char ID;
private BigDecimal price;
//for possible product name implementation
private String name;

public Item(char ID, float price){
	setID(ID);
	setPrice(new BigDecimal(price));
	setName("sample product "+ID);
}
//mutators/accessors
public char getID(){
	return ID;
}
protected void setID(char ID){
	this.ID = ID;
}
public BigDecimal getPrice(){
	return price;
}
protected void setPrice(BigDecimal price){
	this.price = price;
}
public String getName(){
	return name;
}
protected void setName(String name){
	this.name = name;
}


}
