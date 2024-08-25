/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration1;

import java.util.Scanner;

public class LabbettQ6 {

        public static void main(String[] args) {
            Scanner input = new Scanner (System.in);

            int amount;
            int Decision;
            double Swedishkrona, Norwegiankrone, Danishkrone;


            System.out.println("Enter amount in Euro:");
            amount = input.nextInt();
            System.out.println("Select the currency you want to convert to: ");
            System.out.println("1 Swedish krona"); System.out.println("2 Norwegian krone"); System.out.println("3 Danish krone");
            System.out.println("4 Abort conversion");
            Decision = input.nextInt();

            switch (Decision)
            {
                case 1:
                    Swedishkrona = (amount * 10.72); System.out.println(amount + " Euro is equal to " + Swedishkrona + " SEK");
                    break;

                case 2:
                    Norwegiankrone = (amount * 10.17); System.out.println(amount + " Euro is equal to " + Norwegiankrone + " NOK");
                    break;

                case 3:
                    Danishkrone = (amount * 7.44); System.out.println(amount + " Euro is equal to " + (Danishkrone) + " DKK");
                    break;

                case 4:
                    System.out.println("Conversion aborted!");
                    break;

                default:
                    System.out.println("Invalid input");
            }

        }
    }




