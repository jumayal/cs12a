//Lawn.java
//Juan Ayala
//jumaayal
//pa1
//takes input from user and states lawn area and mowing time
import java.util.Scanner;
class Lawn{
    public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double lenLot = input.nextDouble(); // length of the lot
        double widLot = input.nextDouble(); // width of the lot
        double lenHouse = input.nextDouble(); // length of the house
        double widHouse = input.nextDouble(); // width of the house
      
        double lawnArea =( lenLot * widLot) - ( lenHouse * widHouse); // the lawn area
        System.out.println("The lawn area is " + lawnArea + " square feet.");
    
        double mowingRate = input.nextDouble();
        input.close();
		
		//uses inputs to compute time in hour, minute, and second
        double mowingTime = lawnArea/mowingRate;
        int hour = (int)(mowingTime/3600);
        int minute =(int)((mowingTime - (hour*3600))/60);
        int second = (int)(Math.round((mowingTime-(hour*3600))%60));

		//Decides whether to use plural or not
        String pluralHour;
        String pluralMin;
        String pluralSec;
		if(hour==1){
			pluralHour = " hour ";
		}else{
			pluralHour = " hours ";
		}
		if(minute==1){
			pluralMin = " minute ";
			}else{
			pluralMin = " minutes "; 
		}
		if(second==1){
			pluralSec = " second.";	
		}else{
			pluralSec = " seconds.";
		}
		System.out.println("The mowing time is " + hour + pluralHour + minute + pluralMin + second + pluralSec);
    }
}
