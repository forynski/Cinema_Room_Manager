package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int r = scanner.nextInt();
        System.out.println("Enter the number of seats in each rows:");
        int c = scanner.nextInt();

        int rows = r + 1;
        int cols = c + 1;

        int[][] myArray = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                myArray[i][0] = i;
                myArray[0][j] = j;
            }
        }
        for (int i = 0; i < myArray.length; i++)
            System.out.println(Arrays.toString(myArray[i])
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));

    }
}
