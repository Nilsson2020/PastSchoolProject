/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration1;

import java.util.*;

public class LabbettQ3{


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter given time in Seconds: ");

        int seconds = in.nextInt();
        int Sec = seconds % 60;
        int H = seconds / 60;
        int Min = H % 60;
        H = H / 60;
        System.out.print( "Hours: " + H + " Minutes: " + Min + " Seconds: " + Sec);

    }
}

