//Queens.java
//Juan Ayala
//jumaayal
//pa5
//Provides the amount of queens that can be placed in an nxn board

public class Queens {
	static public void main(String[] args){
		int n = args.length;
		String input="";
		int input2=0;
		
		//Checks if there is an argument
		if(n==0){
			System.out.println("Usage: Queens [-v] number");
			System.out.println("Option: -v verbose output, print all solutions");
			System.exit(0);
			
		}
		
		//Takes inputs with expectations of Exceptions
		for(int i =0;i<n;i++){
			try{
				input2 = Integer.parseInt(args[i]);
			}catch(NumberFormatException e){
				input = args[i];
				continue;
			}
		}
		
		int [] solutions =createArray(input2);   //Creates array with numbers to input2
		int numOfPerms = numOfPerm(input2);   //The amount of permutations
		
		if(input.equals("-v") && input2>0){   //Command has -v and number
			//printCorrectPerm(solutions,numOfPerms);
			System.out.println(input2+"-Queens has "+ printCorrectPerm(solutions,numOfPerms) + " solutions");
			
		}else if (input.equals("") && input2 >0){   //Command has only number
			System.out.println(input2+"-Queens has "+ numOfCorrectPerm(solutions,numOfPerms)+ " solutions");
			
		}else{   // Command is used incorrectly
			System.out.println("Usage: Queens [-v] number");
			System.out.println("Option: -v verbose output, print all solutions");
			System.exit(0);
		}
		
	}
	
	//Returns true if chess pieces are not diagonal from each other
	static boolean isSolution(int[] A){
		int horz=0;
		int vert=0;
		boolean solution = true;
		
		mainLoop:
		for(int i= 1;i<(A.length);i++){
			for(int j =i;j<(A.length);j++){
				horz = Math.abs(A[i]-A[j]);
				vert = Math.abs(i-j);
				if(vert !=0 && (horz == vert)){
					solution = false;
					break mainLoop;
				}
			}
		}
		
		return solution;
	}
	
	//Changes the Permutation to the next lexicographic order
	static void nextPermutation(int[] A){
		int pivot= 0, successor= 0,temp, n =A.length -1, temp2,repeat = A.length/2;
		boolean fndPivot= false;

		for(int i= 1;i<n;i++){
			if(A[n-i]<A[A.length-i]){
				pivot = n-i;
				fndPivot = true;
				break;
			}
		}
		
		if(fndPivot == false){
			
			for (int i = 1;i<repeat;i++){
				temp2 =A[i];
				A[i]= A[A.length-i];
				A[A.length -i] = temp2;
			}
			
			return;
		}
		
		for(int i= 1;i<n;i++){
			if(A[A.length-i]>A[pivot]){
				successor = A.length-i;
				break;
			}
			
		}
		
		temp = A[successor];
		A[successor]=A[pivot];
		A[pivot]=temp;

		reverseFromIndex(A,pivot);
		
		return;
	}
	
	//Creats the intial array from numbers up to A
	static int[] createArray(int A){
		int [] example = new int[A+1];
		
		for(int i = 0; i<=A; i++){
			example[i]=i;
		}
		
		return example;
	}
	
	//Returns the amount of Permutations that follow arguement
	static int numOfCorrectPerm(int[] A, int B){
		int num=0;
		
		for(int k =1; k<B;k++){
			if(isSolution(A)){
				num+=1;
			}
			nextPermutation(A);
		}
		
		return num;
	}
	
	//Returns the amount of Permutations that can be made
	static int numOfPerm(int n){
		if(n>0){
			return n*numOfPerm(n-1);
		}else{
			return 1;
	  }
	}
	
	//Prints out an Array on one line
	static void printArray(int A[]){
		
		System.out.print("(" + A[1]);
		for(int i =2; i<A.length;i++){
			System.out.print( ", " + A[i] );
		}
		
		System.out.print(")");
		System.out.println("");
	}
	
	//Prints out the Permutations that follow argument and returns the amount of correct permutations
	static int printCorrectPerm(int[] A, int B){
		int num = 0;
		for(int i= 1; i < B;i++){
			if(isSolution(A)){
				printArray(A);
				num +=1;
			}
			
			nextPermutation(A);
		}
		return num;
	}
	
	
	//Reverses the numbers right of the pivot
	static void reverseFromIndex(int[]A, int pivot){
		int startSwap =pivot+1;
		int lengthOfChange = A.length - startSwap;
		int n =A.length -1;
		int temp;
		
		for (int i = 0; i < (lengthOfChange/2);i++){ 
			temp = A[startSwap+i];
			A[startSwap+i]=A[n-i];
			A[n-i] = temp;
		}
		
		
	}
} 