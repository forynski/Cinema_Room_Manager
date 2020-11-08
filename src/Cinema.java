package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt() + 1;
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt() + 1;

        char[][] room = new char[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                room[i][j] = 'S';
            }
        }

        int menu;

        do {
            menu = getMenu(scanner);
            switch (menu) {
                case 1:
                    render(room);
                    break;
                case 2:
                    booking(scanner, rows, seats, room);
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: ");
                    System.out.println("Percentage: ");
                    System.out.println("Current income: ");
                    System.out.println("Total income: ");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Incorrect selection, please try again!");
                    break;
            }
        } while (menu != 0);
    }

    public static int getMenu(Scanner scanner) {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }

    public static void booking(Scanner scanner, int rows, int seats, char[][] room) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("" + "Enter a seat number in that row:");
        int seat = scanner.nextInt();
        int ticket;
        if ((rows - 1) * (seats - 1) < 60) {
            ticket = 10;
        } else if (row <= (rows - 1) / 2) {
            ticket = 10;
        } else ticket = 8;
        System.out.println("\nTicket price: " + "$" + ticket + "\n");

        room[row][seat] = 'B';
        render(room);
    }

    private static void render(char[][] room) {
        System.out.print("Cinema:\n ");
        for (int i = 1; i < room[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        int a = 1;

        for (int i = 1; i < room.length; i++) {
            System.out.print(a++);
            for (int j = 1; j < room[0].length; j++) {
                System.out.print(" " + room[i][j]);
            }
            System.out.println();
        }
    }
}
