
package Labbration2;

import java.util.Scanner;


public class LabbtvåQ6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a;
        System.out.println("Enter your salary here:");
        a = input.nextInt();
        int b = netSalary(a);

        System.out.println("Net salary:" + b);
    }


    public static int netSalary(int num1) {

        System.out.println("Gross salary is: " + num1);

        if (num1 > 0){ System.out.println("The church fee: " + (num1*(0.22f/100.0f)));
            num1 = (int) (num1*(99.78f/100.0f));}


        if (num1 < 200000) {
            System.out.println("Tax: " + (num1*(20.0f/100.0f) ));
            num1 = (int) (num1*(80.0f/100.0f));}

        else if (num1 > 200000 && num1 <= 468000){
            System.out.println("Tax: " + (num1*(32.12f/100.0f) ));
            num1 = (int) (num1*(67.88f/100.0f));}

        else if (num1 > 468000 && num1 <=675000){
            System.out.println("Tax: " + (num1*(52.35f/100.0f) ));
            num1 = (int) (num1*(47.65f/100.0f));}

        else if (num1 > 675000) {
            System.out.println("Tax:" + (num1*(57.48f/100.0f) ));
            num1 = (int) (num1*(42.52f/100.0f));
        }

        return num1;
    }

}

