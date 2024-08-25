/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration2;

import java.util.Scanner;

public class LabbtvåQ5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Enter a personal number: ");
            String pNum = input.nextLine();
            String continueloop = "continue";

            boolean istrue = (pNum.length() == 13 &&
                    Character.isDigit(pNum.charAt(0)) &&
                    Character.isDigit(pNum.charAt(1)) &&
                    Character.isDigit(pNum.charAt(2)) &&
                    Character.isDigit(pNum.charAt(3)) &&
                    Character.isDigit(pNum.charAt(4)) &&
                    Character.isDigit(pNum.charAt(5)) &&
                    Character.isDigit(pNum.charAt(6)) &&
                    Character.isDigit(pNum.charAt(7)) &&
                    pNum.charAt(8) == '-' &&
                    Character.isDigit(pNum.charAt(9)) &&
                    Character.isDigit(pNum.charAt(10)) &&
                    Character.isDigit(pNum.charAt(11)) &&
                    Character.isDigit(pNum.charAt(12))
            );
            if (istrue) {
                System.out.println("Personal identity number is correct");
            } else {
                System.out.println("Invalid personal identity number");
            }
            System.out.println("Enter \"continue\" to continue and \"quit\" to quit: ");
        }while (in.nextLine().equalsIgnoreCase("continue"));
    }

}
