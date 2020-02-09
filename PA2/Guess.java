//Guess.java
//Juan Ayala
//jumaayal
//pa2
// A guessing game telling the user if close to random number or not
import java.util.Scanner;
import java.util.Random;
class Guess{
    public static void main(String[]args){
        int max;
        int min;
        int tries = 0;
        boolean win= false;
        Random num = new Random();
        int randomNumber = num.nextInt(9)+1;
        Scanner input = new Scanner(System.in);
        System.out.println("I'm thinking of an integer in the range 1 to 10. You hava three guesses.");
        
        while(win==false && tries<3){
            
            if(tries == 0){
                System.out.print("Enter your first guess: ");
            }
            if(tries == 1){
                System.out.print("Enter your second  guess: ");
            }
            if(tries == 2){
                System.out.print("Enter your third guess: ");
            }

            int guess = input.nextInt();

            if(guess< randomNumber){
                System.out.println("Your guess is too low");
            }else if (guess == randomNumber){
                win = true;
            }else{
                System.out.println("Your guess is too high");
            }

            tries = tries + 1;
        }

        if( win == true){
            System.out.println("You win!");
        }else{
            System.out.println("You lose!");
			//please tell me this works
        }
    }
}	
