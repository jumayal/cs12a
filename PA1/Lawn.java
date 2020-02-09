//Lawn.java
//Juan Ayala
//jumaayal
//pa1
//takes input from user and states lawn area and mowing time
import java.util.Scanner;
class Lawn{
    public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the length and width of the lot, in feet: ");
	double lenLot = input.nextDouble();
        double widLot = input.nextDouble();
        System.out.print("Enter the length and width of the house, in feet: ");
        double lenHouse = input.nextDouble();
        double widHouse = input.nextDouble();
      
        double lawnArea =( lenLot * widLot) - ( lenHouse * widHouse);
        System.out.println("The lawn area is " + lawnArea + " square feet.");
      
        System.out.print("Enter the mowing rate, in square feet per second: ");
        double mowingRate = input.nextDouble();
        input.close();
      
        double mowingTime = lawnArea/mowingRate;
        int hour = (int)(mowingTime/3600);
        int minute =(int)((mowingTime - (hour*3600))/60);
        int second = (int)(Math.round((mowingTime-(hour*3600))%60));

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
