
package Labbration2;

import java.util.Scanner;

public class LabbtvåQ1 {
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            String sentence;
            System.out.println("Enter a line of text:");
            sentence = input.nextLine();
            String[] splits = sentence.split(" ");
            for(String splits2: splits) {
                System.out.println(splits2);
            }
        }

}

