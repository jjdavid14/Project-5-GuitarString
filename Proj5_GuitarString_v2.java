/*Proj5_GuitarString_v3
 * 
 * CSc 127A Fall 15, Project 5
 * 
 * Author: Jamie John David
 * SL Name: Sujan Patel (Section C)
 * 
 * -- 
 * The purpose of this program is to display an oscillation
 * of lines using the heights of randomly generated numbers
 * which are going to be stored in an array.
 */

import java.util.Random;

public class Proj5_GuitarString_v3 {
    
    public static void main(String[] args) {
        
        final int ELEMENTS = 100;    //number of elements for the array
        double[] heightString = new double[ELEMENTS];  //initialize array
        double[] velocity = new double[ELEMENTS]; //array for velocity
        Random rand = new Random();  //create Random object for random numbers
        
        //First and last values initialized to zero
        //represents the two endpoints of string
        heightString[0] = 0;
        heightString[ELEMENTS - 1] = 0;
        
        //initialize a constant minimum and maximum
        //for the range of random numbers
        final int MIN = -50;
        final int MAX = 50;
        
        //initialize remaining values to random numbers
        //between -50 and 50
        for(int i = 1; i<heightString.length - 1; i++) {
            heightString[i] = (MIN) + rand.nextDouble() * (MAX - MIN);
        }
        
        StdDraw.setXscale(0,ELEMENTS); //sets scale of width ELEMENT-0
        StdDraw.setYscale(-100,100);   //sets scale of height 100-(100)
        
        //draw the animation of the oscillation
        while(true) {
            StdDraw.line(0,0,ELEMENTS,0);  //draws line in middle
            
            //Iterates over array to draw oscillation of line
            for(int j = 0; j<heightString.length-1;j++) {
                StdDraw.line(j,heightString[j],j+1,heightString[j+1]);
            }  
            StdDraw.show(0);
            StdDraw.clear();
            
            //update velocity
            for (int k = 1; k < velocity.length - 1; k++) {
                velocity[k] = velocity[k] + 0.01*(heightString[k-1] +
                               heightString[k+1] -2 * heightString[k]);
            }
        
            //update height
            for (int l = 1; l < heightString.length - 1; l++) {
                heightString[l] = 0.999*heightString[l] + velocity[l];
            }
            
            //check if mouse is pressed, if so, update height at location
            if(StdDraw.mousePressed()) {
                int myVar = (int)(StdDraw.mouseX()+.5);
                heightString[myVar] = StdDraw.mouseY();
            }
        }
    }
}
