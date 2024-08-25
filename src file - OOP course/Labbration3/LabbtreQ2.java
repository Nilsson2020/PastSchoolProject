/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration3;
import java.util.Scanner;
public class LabbtreQ2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String kurs;
        String[] kurskod = {"1ik013", "1ik161", "1ik162", "1ik221", "1ik073"};
        String[] kursnamn = {"Design av Databaser", "Grundläggande Programering",
                "Objektorienterad programmering", "Grundläggande projektmetodik", "Problemstrukturering"};

        System.out.println("Ange en kurskod: ");
        kurs = input.next();
        int x = 0;

        for (int i = 0; i < kurskod.length; i++) {
            if (kurskod[i].equals(kurs)) {
                System.out.println("Kuren heter " + kursnamn[i]);
            }
            else x++;
        }
        if (x==5) {
            System.out.println("Kursen hittades inte");
        }
    }
}