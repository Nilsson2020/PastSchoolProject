package Labbration3;
import java.util.Random;
public class LabbtreQ6
 {
    public static void main(String[] args) {
        Random abc = new Random();
        System.out.println("Myran");
        System.out.println("=====");
        int totalSteps = 0;
        for (int i = 0; i < 10; i++) {

            int direction = 0, antal = 0;

            int[][] brada = new int[8][8];
            System.out.print("Total number of steps on yard " + (i + 1) + ": ");
            //visar antalet steg
            int x = abc.nextInt(8);
            int y = abc.nextInt(8);

            while (direction < 64) {

                int movement = abc.nextInt(4);

                if //upp
                (movement == 0) {
                    if
                    (y < 7)
                        y++;
                    if
                    (brada[x][y] != 1) {

                        direction++;
                    }
                    brada[x][y] = 1;

                }
                else if //ner
                (movement == 1) {
                    if
                    (y > 0)
                        y--;
                    if
                    (brada[x][y] != 1) {
                        direction++;
                    }
                    brada[x][y] = 1;
                }
                else if
                (movement == 2) {
                    if
                    (x > 0)
                        x--;
                    if
                    (brada[x][y] != 1) {
                        direction++;
                    }
                    brada[x][y] = 1;
                }
                else
                {
                    if
                    (x < 7)
                        x++;
                    if
                    (brada[x][y] != 1) {
                        direction++;
                    }
                    brada[x][y] = 1;
                }
                antal++;
            }
            totalSteps= totalSteps + antal;

            System.out.print(antal + "\n");
        }
    }
}
