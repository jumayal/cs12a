/*Sphere.c
 * Juan Ayala
 * jumaayal
 * lab7
 * Takes input of the radius and returns volume and surface area
 */
#include<stdio.h>
#include<math.h>


int main(){
   double radius, volume, surfaceArea;
   const double pi = 3.141592654;
   
   printf("Enter the raduis of the sphere: ");
   scanf("%lf", &radius);
   volume  = (4.0/3.0)*pi*pow(radius,3);
   surfaceArea = 4*pi*pow(radius,2);  
   printf("The volume is %f and the surface area is %f.\n", volume, surfaceArea);
   
   return 0;
}
