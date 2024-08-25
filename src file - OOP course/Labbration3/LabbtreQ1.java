

package Labbration3;

import java.util.Scanner;

public class LabbtreQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] arr = new int[9];
        System.out.println("Ange tio personers ålder: ");
        int x = 0;
        while (x < arr.length) {
            arr[x]= in.nextInt();
            x++;
        }
        int ung = 0;
        int medel = 0;
        int gammal = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 66)
                gammal++;
            else if (arr[i] >= 18)
                medel++;
            else {
                ung++;
            }
        }
        int [] young = new int[ung];
        int [] middle = new int[medel];
        int [] old = new int[gammal];

        int z = 0, y = 0, k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 66)
                old[z] = arr[i];
            else if (arr[i] >= 18)
                middle[y] = arr[i];
            else {
                young[k] = arr[i];
            }
        }
        System.out.println("<18: " + young.length + " personer");

        System.out.println("18-65: " + middle.length + " personer");

        System.out.println("65+: " + old.length + " personer");
    }
}