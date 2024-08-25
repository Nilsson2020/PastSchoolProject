
package Labbration1;

import	java.util.Scanner;
public class LabbettQ5 {
    //main method
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);

        //Declared an integer variable
        int inNumber ;

        //printing and ask for input of five numbers
        System.out.println("Lägg in 5 nummer: ");
        inNumber = input.nextInt();


        //initializing count as 1
        int count =0;

        //compare each digit with others
        //we will start comparing from rightmost digit with leftmost digits
        while (inNumber > 0){

            //get the rightmost digit
            int digit = inNumber % 10;

            //remove the rightmost digit and get the updated number
            inNumber = inNumber / 10;

            //assign the updated original number(rightmost digit removed) to a temp variable
            int temp = inNumber;

            //check if the rightmost digit matches with leftmost digits
            while (temp > 0){

                //if rightmost digit matches with any leftmost digit then
                //increment count value
                //and break
                if (temp % 10 == digit){
                    count = 1;
                    break;
                }

                //remove rightmost digit from temp
                //and get updated temp value
                temp = temp / 10;
            }
        }
        //if count value is 1 then print unique else duplicates
        if (count == 0){
            System.out.println("Alla är unika");
        }


        else {
            System.out.println("Det finns dubbletter");
        }
    }
}