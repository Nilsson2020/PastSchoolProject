package Labbration2;

import java.io.*;

class LabbtvåQ4
{
    static void pattern(int rows_no)
    {
        int a, b, c;

        for (a = 1; a <= rows_no; a++) {


            for (c = 1; c < a; c++)
                System.out.print(" ");


            for (b = a; b <= rows_no; b++)
                System.out.print(b + " ");

            System.out.println();
        }

        for (a = rows_no - 1; a >= 1; a--)
        {
            for (c = 1; c < a; c++)
                System.out.print(" ");


            for (b = a; b <= rows_no; b++)
                System.out.print(b + " ");

            System.out.println();
        }
    }

    public static void main (String[] args)
    {

        int rows_no = 10;

        pattern(rows_no);

    }
}