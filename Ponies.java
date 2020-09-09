package hw0;

/**
*@author Nikolo Sperberg
*
*This class creates pony objects.  Ponies have names and ages.
*/

public class Ponies {
	
	//Declaration of name and age
	String name; 
	int age;
	
	
	/**
	*this method sets the ponies name
	*/
	public void setName(String n) {
		name = n;
	}
	
	/**
	*this method sets the ponies age
	*/
	public void setAge(int x) {
		age = x;
	}
	
	/**
	*this method gets the ponies name
	*/
	public String getName() {
		return name;
	}
	
	/**
	*this method gets the ponies age
	*/
	public int getAge() {
		return age;
	}
	
}