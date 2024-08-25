

/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Labbration1;

import java.lang.Math;

public class LabbettQ1 {

    public static void main(String[] args) {
        System.out.println("Följade lista består av 6st slumpmässigt genererade 3-siffriga heltal: ");
        int a = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int b = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int c = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int d = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int e = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int f = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int g = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int h = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int i = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        int j = (int) (((Math.random() * 899 ) + 100) * Math.signum(Math.random()-0.5));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);

        int FNa = a % 10;
        a = a / 10;
        int ANa = a % 10;
        if (ANa < 0) ANa *= (-1);

        int FNb = b % 10;
        b = b / 10;
        int ANb = b % 10;
        if (ANb < 0) ANb *= (-1);

        int FNc = c % 10;
        c = c / 10;
        int ANc = c % 10;
        if (ANc < 0) ANc *= (-1);

        int FNd = d % 10;
        d = d/ 10;
        int ANd = d % 10;
        if (ANd < 0) ANd *= (-1);

        int FNe = e % 10;
        e = e / 10;
        int ANe = e % 10;
        if (ANe < 0) ANe *= (-1);

        int FNf = f % 10;
        f = f / 10;
        int ANf = f % 10;
        if (ANf < 0) ANf *= (-1);

        int FNg = g % 10;
        g = g / 10;
        int ANg = g % 10;
        if (ANg < 0) ANg *= (-1);

        int FNx = h % 10;
        h = h / 10;
        int ANh = h % 10;
        if (ANh < 0) ANh *= (-1);

        int FNh = i % 10;
        i = i / 10;
        int ANi = i % 10;
        if (ANi < 0) ANi *= (-1);

        int FNj = j % 10;
        j = j / 10;
        int ANj = j % 10;
        if (ANj < 0) ANj *= (-1);

        System.out.println("Summan av de mellersta siffrorna är: " + (ANa+ANb+ANc+ANd+ANe+ANf+ANg+ANh+ANi+ANj));
    }
}
