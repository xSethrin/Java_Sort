package hw0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
*@author Nikolo Sperberg
*
*This program takes a text file of ponies with ages, puts them in an array, sorts them by age, and then prints off the
*result without printing two ponies with the same name.
*
*/

public class PonySort {
	
	/**
	 * main method
	 * @param args - must be a text file in correct format
	 * @throws FileNotFoundException
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		//if no arguments are passed dies nicely
		if(args.length != 1) {
			System.out.println("This program requires a single text file to run\nexiting...");
			System.exit(0);
		}
		else {
			File f = new File(args[0]);
			//if text file is empty dies nicely
			if(f.length() == 0) {
				System.out.println("File empty\nexiting...");
				System.exit(0);
			}
			else { 
				Scanner scan = new Scanner(f);
				Ponies[] ponyArray = parseFile(scan);
				ponyArray = sortPonies(ponyArray);
				printPonies(ponyArray);
			}
		}
	}
	
	/**
	 * 
	 * @param scan - the passed text file
	 * this method scans the file and gathers the age and name of the ponies
	 * this method then uses that data to make ponies and puts each pony into an array
	 * 
	 */
	
	public static Ponies[] parseFile(Scanner scan) {
		int i = 0;//int to parse string string
		int k = 0;//int to hold pos of pony array
		int count;//int to count number of char in txt file
		int n = 0;//int to count number of ponies in txt file
		int age = 0;//int tohold gae of pony
		String name = "";//string to hold name of pony
		String temp = "";//temp string to hold data
		String ponies = "";//string to hold text file data
		
		//this loop is to make sure each line is grabbed
		while(scan.hasNextLine()) {
			Scanner line = new Scanner(scan.nextLine());
			//this loop is to make sure each token is grabbed
			while(line.hasNext()) {
				ponies = ponies + line.next();
			}
		}
		//if text file only has tabs will exit program nicely
		if(ponies.length() == 0) {
			System.out.println("File contains no ponies\nexiting...");
			System.exit(0);

		}
		count = ponies.length();
		
		//this loop counts each pony in the txt file
		while(count >= i+1) {
			if (ponies.charAt(i) == ',') {
				n++;
			}
			i++;
		}
		i = 0;
		Ponies[] ponyArray = new Ponies [n];
		
		//this loop goes through the text file and gets the data for each pony
		while(count >= i+1) {
			if (ponies.charAt(i) == '(') {
				i++;
				while(ponies.charAt(i) != ',') {
					temp = temp + ponies.charAt(i);
					i++;
				}
				age = Integer.parseInt(temp); 
				i++;
				temp = "";
				while(ponies.charAt(i) != ')') {
					temp = temp + ponies.charAt(i);
					i++;
				}
				name = temp;
			}
			Ponies pony = new Ponies();//make new pony
			pony.setAge(age);//set new pony age
			pony.setName(name);//set new pony name
			ponyArray[k] = pony;//put pony into array
			k++;//change pos in array
			temp = "";//reset temp
			name = "";//reset name
			age = 0;//reset age
			i++;
			
		}
		/*
		 * this was used to test that the pony array was properly made
		
		int x = ponyArray.length - 1;
		System.out.println("\n\nUNSORTED\n");
		while(x >= 0) {
			System.out.println(ponyArray[x].getAge() + " " + ponyArray[x].getName());
			x--;
		}
		*/
		return ponyArray;
	}
	/**
	 * 
	 * @param ponyArray - array of ponies
	 * @return
	 * 
	 * this method sorts the ponies and then returns the ponies 
	 * its kinda a bubble sort but it uses a while loop that counts the number of swaps made.. so I guess iots worse than a bubble sort
	 * because it keeps looking through the whole array...
	 * 
	 * but I made it myself so I am proud of it
	 * 
	 * I actually didn't even realize I made a bubble sort until I had finished sorting it
	 */
	
	public static Ponies[] sortPonies(Ponies[] ponyArray) {
		boolean flag = true;//used for the while loop
		int count = 0;//counts the swaps made
		while (flag) {
			count = 0;
			for(int i = 0; i <= ponyArray.length-2; i++) {
				if(ponyArray[i].getAge() > ponyArray[i+1].getAge()) {
					Ponies temp1 = ponyArray[i];
					ponyArray[i] = ponyArray[i+1];
					ponyArray[i+1] = temp1;
					count++;
				}
			}
			if(count == 0) {
				flag = false;
			}
		}
		/*
		 * this was used to check if the array
		int x = ponyArray.length - 1;
		System.out.println("\n\nSORTED\n");
		while(x >= 0) {
			System.out.println(ponyArray[x].getAge() + " " + ponyArray[x].getName());
			x--;
		}
		*/
		return ponyArray;
	}
	
	/**
	 * 
	 * @param ponyArray - array of ponies
	 * this method prints the ponies in order skipping ponies that have the same age
	 * 
	 */
	public static void printPonies(Ponies[] ponyArray) {
		int temp = ponyArray[0].getAge();
		System.out.println("Welcome to the Gala, " + ponyArray[0].getName()+ "; Age: " + ponyArray[0].getAge());
		for(int i = 1; i <= ponyArray.length - 1; i++) {
			if(ponyArray[i].getAge() != temp) {
				System.out.println("Welcome to the Gala, " + ponyArray[i].getName()+ "; Age: " + ponyArray[i].getAge());
				temp = ponyArray[i].getAge();
			}
		}
	}
}