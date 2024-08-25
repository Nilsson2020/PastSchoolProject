
package Labbration3;

import java.util.Scanner;
public class LabbtreQ3 {

    public static void main(String[] args) {
    System.out.print("Ange arrayens element: ");
    Scanner input = new Scanner(System.in);
    int [] arr = new int[10]; // Declare an array

    for(int i = 0; i < arr.length; i++){ // Adds input into array
        arr[i] = input.nextInt(); // Assign numbers to the array to store values
    }

    System.out.println("Ökande subarrayer är: ");

    // Loops that checks if variable at index i is bigger than previous number and less than next number
    for (int j = 0; j < arr.length; j++) { // Execute 10 iterations
        if (j + 1 < arr.length && arr[j+1] > arr[j]) { // Index right > index left
            System.out.print(arr[j]+ " ");

        } else if(j>0 && arr[j-1] < arr[j]) { // Index left < index right
            System.out.println(arr[j]);
        }
    }
}
}
