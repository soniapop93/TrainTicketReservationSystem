package Logic;

import java.util.Scanner;

public class LogicTrainTicketReservationSystem {
    public void reservationSystem() {
        printWelcomeMessage();
    }

    private String getInputFromUser() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void printWelcomeMessage() {
        System.out.println("=================================================");
        System.out.println("Welcome to the Train Ticket Reservation System");
        System.out.println("=================================================");
    }
}
