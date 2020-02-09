/*
 * GCD.c
 * Juan Ayala
 * jumaayal
 * lab8
 * Finds the GCD of two positive integers
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int isInteger(char s[]){
   int i, n;

   if( s==NULL )
      return 0;
   n = strlen(s);
   if( n==0 )
      return 0;
   if( s[0]!='-' && s[0]!='+' && !isdigit(s[0]) )
      return 0;
   for(i=1; i<n; i++){
      if( !isdigit(s[i]) )
         return 0;
   }
   return 1;
}

int main(void){
	int x, y,n,p,dividend,divisor,remainder =1;
	char str[200];
	printf("Enter a positive integer: ");
	while(1){
		n = scanf("%s", str);
		if( isInteger(str) ){
			sscanf(str, "%d", &x);
			if(x>0){
				break;
			}
		}
		printf("Please enter a positive integer: ");
	}

	printf("Enter another positive integer: ");
	while(1){
		p = scanf("%s", str);
		if( isInteger(str) ){
			sscanf(str, "%d", &y);
			if(x>0){
				break;
			}
		}
		printf("Please enter a positive integer: ");
	}
	if(x>y){
		dividend = x;
		divisor=y;
	}else{
		dividend = y;
		divisor = x;
	}
	while(remainder !=0){
		remainder = dividend%divisor;
		dividend = divisor;
		divisor = remainder;
	}
	printf("The GCD of %d and %d is %d\n", x,y,dividend);
}
