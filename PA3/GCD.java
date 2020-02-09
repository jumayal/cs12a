//GCD.java
//Juan Ayala
//jumaayal
//pa3
//Finds greatest common divisor
import java.util.Scanner;
class GCD{
	public static void main (String[] args){
		int firstInt;
		int secInt;
		int quotient =0;
		int remainder=1;
		int dividend;
		int divisor;
		
		Scanner sc = new Scanner(System.in);
		
		//Checks whether first input is an integer and positive
		System.out.print("Enter a positive integer: ");
		while(true){
			while((!sc.hasNextInt())){
				System.out.print("Please enter a positive integer: ");
				sc.next();
			}
			firstInt = sc.nextInt();
			if(firstInt > 0){
				break;
			}else{
				System.out.print("Please enter a positive integer: ");
			}
		}
		
		//Checks whether second input is an integer and positive
		System.out.print("Enter another positive integer: ");
		while(true){
			while((!sc.hasNextInt())){
				System.out.print("Please enter a positive integer: ");
				sc.next();
			}
			secInt = sc.nextInt();
			if(secInt > 0){
				break;
			}else{
				System.out.print("Please enter a positive integer: ");
			}
		}
			
		//Figures which input is larger and assign appropriate names	
		if(secInt>firstInt){
			dividend = secInt;
			divisor= firstInt;
		}else{
			dividend = firstInt;
			divisor = secInt;
		}
				 
		//Loops through Euclidean Algorithm to find quotient
		while(remainder!=0){
			remainder = dividend%divisor;
			dividend = divisor;
			divisor = remainder;
		}
		
		
		System.out.println("The GCD of " + firstInt+ " and " + secInt  + " is " + dividend);
	}
}
