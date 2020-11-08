package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] cinema = new String[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = "S";
            }
        }

        while (true) {
            showMenu();
            switch (scanner.nextInt()) {
                case 1:
                    showCinema(cinema);
                    break;
                case 2:
                    takeASeat(cinema);
                    break;
                case 3:
                    showStatistics(cinema);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Incorrect selection, please try again!");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void showCinema(String[][] cinema) {
        System.out.println("Cinema:");

        for (int i = 0; i < cinema.length + 1; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            for (int j = 0; j < cinema[0].length; j++) {
                if (i == 0) {
                    System.out.print(j + 1 + " ");
                } else {
                    if (j == 0) {
                        System.out.print(i + " ");
                    }
                    System.out.print(cinema[i - 1][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void takeASeat(String[][] cinema) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a row number:");
            int pickRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int pickSeat = scanner.nextInt();
            if (pickRow <= 0 || pickRow > cinema.length || pickSeat <= 0 || pickSeat > cinema[0].length) {
                System.out.println("Wrong input!");
            } else {
                if ("S".equals(cinema[pickRow - 1][pickSeat - 1])) {
                    cinema[pickRow - 1][pickSeat - 1] = "B";
                    int ticketPrice = cinema.length * cinema[0].length <= 60 ? 10 : pickRow <= cinema.length / 2 ? 10 : 8;
                    System.out.printf("Ticket price: $%d\n", ticketPrice);
                    break;
                } else {
                    System.out.println("That ticket has already been purchased!");
                }
            }
        }
    }

    public static void showStatistics(String[][] cinema) {

        double percentage;
        int purchasedTickets = 0;
        int currentInc = 0;
        int totalInc = cinema.length * cinema[0].length <= 60 ?
                (cinema.length * cinema[0].length) * 10 : cinema.length % 2 == 0 ?
                ((cinema.length / 2) * cinema[0].length * 10) + (cinema.length / 2) * cinema[0].length * 8 :
                ((cinema.length / 2) * cinema[0].length * 10) + ((cinema.length / 2) + 1) * cinema[0].length * 8;

        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if ("B".equals(cinema[i][j])) {
                    purchasedTickets++;

                    if (cinema.length * cinema[0].length <= 60) {
                        currentInc += 10;
                    } else {
                        currentInc += i <= cinema.length / 2 - 1 ? 10 : 8;
                    }
                }
            }
        }

        percentage = (double) purchasedTickets / (cinema.length * cinema[0].length) * 100;

        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + currentInc);
        System.out.println("Total income: $" + totalInc);
    }
}
