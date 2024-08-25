
package Labbration3;

import java.util.Scanner;

public class LabbtreQ5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[][] arr1 = new int[3][4];
        int[][] arr2 = new int[4][3];


        System.out.println("Ange matrisen: ");
        int z = 1;
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 4; y++) {
                System.out.print("Ange tal " + (z)+ ": ");
                arr1[i][y] = in.nextInt();
                z++;
            }
        }
        for (int[] x: arr1) {
            for(int y: x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println();

        int y = 0;
        int x = 0;
        for (int j = arr2[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < arr2.length; i++) {
                arr2[x][y] = arr1[j][i];
                x++;
            }

            x = 0;
            y++;
        }
        System.out.println("\nAfter");
        for (int[] k: arr2) {
            for(int l: k) {
                System.out.print(l + " ");
            }
            System.out.println();
        }

    }
}