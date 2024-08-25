/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration3;
import java.util.Scanner;
public class LabbtreQ4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int antal = 4;
        int[] array = new int[antal];
        System.out.println("Mata in vilka tal du vill använda: ");

        for (int i = 0; i < array.length; i++) {
            System.out.print("Nummer " + (i + 1) + ": ");
            array[i] = in.nextInt();
        }

        rotera(array);
    }

    static void rotera(int[] arr) {
        int[][] matris = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                matris[i][j] = arr[(i + j) % arr.length];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }
    }
}