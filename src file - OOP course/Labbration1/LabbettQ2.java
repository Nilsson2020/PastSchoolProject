/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration1;

import java.lang.Math;

public class LabbettQ2 {

     public static void main(String[] args) {
            System.out.println("Följade lista består av 6st slumpmässigt genererade 3-siffriga heltal: ");
            int a = (int) (((Math.random() * 899) + 100) * Math.signum(Math.random() - 0.5));
            int b = (int) (((Math.random() * 899) + 100) * Math.signum(Math.random() - 0.5));
            int c = (int) (((Math.random() * 899) + 100) * Math.signum(Math.random() - 0.5));
            int d = (int) (((Math.random() * 899) + 100) * Math.signum(Math.random() - 0.5));
            int e = (int) (((Math.random() * 899) + 100) * Math.signum(Math.random() - 0.5));
            int f = (int) (((Math.random() * 899) + 100) * Math.signum(Math.random() - 0.5));
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);
            System.out.println(f);

            int max = Math.max(Math.max(Math.max(Math.max(Math.max(a,b),c),d),e),f);
            int min = Math.min(Math.min(Math.min(Math.min(Math.min(a,b),c),d),e),f);
            System.out.println("Maximum number is " + max);
            System.out.println("Minimum number is " + min);

            int FNmax = max % 10;
            max = max / 10;
            int ANmax = max % 10;
            if (ANmax < 0) ANmax *= (-1);

            int FNmin = min % 10;
            min = min / 10;
            int ANmin = min % 10;
            if (ANmin < 0) ANmin *= (-1);

            System.out.println("Summan av mitten sifforon på min och max är: " + (ANmax+ANmin));  }}

