//Roots.java
//Juan Ayala
//jumaayal
//pa4
//Finds the x intercept within a given domain and polynomial function
import java.util.Scanner;
import java.math.BigDecimal;
public class Roots {
	public static void main(String[] args){
		double resolution= 0.01, tolerance= 0.0000001, threshold= 0.001;
		double a,b;
		boolean foundRoot = false;
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter the degree: ");
		int degree= sc.nextInt();
		
		double[] equation= new double [degree+1] ; //initializes array with set range from given degree
		System.out.print("Enter " + (degree+1) + " coefficients: ");
		for (int i = 0; i<(degree+1);i++){ //gathers the amount of coefficients
			equation[i]= sc.nextDouble();
		}
		
		System.out.println("Enter the left and right endpoints: ");
		double left= sc.nextDouble();
		double right= sc.nextDouble();
		sc.close();
		
		double[] derivative= equation.clone(); //Creates a clone array 
		derivative= diff(derivative); //changes to derivative coefficients 
		
		a= left;
		b= left+ resolution;
		while( a <=right){

			if( poly(equation,a) * poly(equation,b) <= 0 ){ //Checks y values are opposite sign
				double root= findRoot(equation,a,b,tolerance); //Finds root based on a and b domain
				System.out.print("Root found at ");
				System.out.printf("%.5f%n", root);
				foundRoot = true;
			}
			else if( poly(derivative,a) * poly(derivative,b) <= 0 ){ //Checks y values are opposite sign
				double root= findRoot(derivative,a,b,tolerance); //Finds roots in derivative
				if( Math.abs( poly(equation,root) ) < threshold ){ //Checks if roots are x-intercepts of original equation
					System.out.print("Root found at ");
					System.out.printf("%.5f%n", root);
					foundRoot = true;
				}
			}
			a=b;
			b=a + resolution;
		}
		if(!foundRoot){
			System.out.println("No roots were found in the specified range.");
		}
	}

	//returns y value of polynomial equation with x input
	static double poly(double[] C, double x){
		int numOfCo= C.length;
		double yValue=0.0;
		for(int i= 0; i<numOfCo; i++){
			yValue = ( C[i] * Math.pow(x, i) )+yValue;
		}
		return yValue;
	}
	
	//gives an array with derivative coefficients
	static double[] diff(double[] C){
		int numOfCo= C.length;
		double[] dif = new double[numOfCo-1];
		for(int i =0;i<(numOfCo-1);i++){
			dif[i] = C[i+1] * (i+1) ;
		}
		return dif;
	}
	
	//bisection method to find root in domain
	static double findRoot(double[] C, double a, double b, double tolerance){
		double mid =a;
		double width =b-a;
		
		while(width >tolerance){
			mid= (b+a)/2.0;
			if(poly(C,a)*poly(C,mid) <=0){
				b= mid;
			}else{
				a= mid;
			}
			width = b-a;
		}
		return mid;
	}
}
