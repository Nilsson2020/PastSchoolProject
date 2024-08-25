/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration2;

import java.util.Scanner;

public class LabbtvåQ3
{
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        int count = 0;
        String string;
        System.out.println("Enter string here:");
        string = input.nextLine();

        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ')
                count++;
        }
        System.out.println("Total number of characters in a string: " + count);
    }
}