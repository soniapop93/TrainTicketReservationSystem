package Logic;

import Users.UserLogic;
import Utilities.InputFromUser;

import java.util.ArrayList;
import java.util.Arrays;

public class LogicTrainTicketReservationSystem {

    private final ArrayList<String> optionList = new ArrayList<String>(Arrays.asList("See available train list", "Make a reservation", "Create new account", "Login in my account", "Logout", "Exit"));
    private boolean loggedIn = false;

    public void reservationSystem() {

        InputFromUser inputFromUser = new InputFromUser();

        String optionStrSelected = ">>> You have selected option: ";

        printWelcomeMessage();

        while (true) {
            optionMenu(loggedIn);
            System.out.print(">>> Add option number: ");
            String input = inputFromUser.getInputFromUser();
            System.out.println("-----------------------");

            if (loggedIn) {
                switch (input) {
                    default:
                        System.out.println("Option not available");
                    case "1": // See available train list
                        System.out.println(optionStrSelected + "1." + optionList.get(0) + "\n");
                        break;
                    case "2": // Make a reservation
                        System.out.println(optionStrSelected + "2." + optionList.get(1) + "\n");
                        break;
                    case "3": // Logout
                        System.out.println(optionStrSelected + "3." + optionList.get(4) + "\n");
                        break;
                    case "4": // Exit
                        System.out.println(optionStrSelected + "4." + optionList.get(5) + "\n");
                        return;
                }
            }
            else {
                switch (input) {
                    default:
                        System.out.println("Option not available");
                    case "1": // See available train list
                        System.out.println(optionStrSelected + "1." + optionList.get(0) + "\n");
                        break;
                    case "2": // Make a reservation
                        System.out.println(optionStrSelected + "2." + optionList.get(1) + "\n");
                        break;
                    case "3": // Create new account
                        System.out.println(optionStrSelected + "3." + optionList.get(2) + "\n");
                        break;
                    case "4": // Login in my account
                        System.out.println(optionStrSelected + "4." + optionList.get(3) + "\n");




                        break;
                    case "5": // Exit
                        return;
                }
            }
        }
    }



    private void printWelcomeMessage() {
        System.out.println("==================================================");
        System.out.println("  Welcome to the Train Ticket Reservation System");
        System.out.println("==================================================");
        System.out.println(" ");
    }
    private void optionMenu(boolean loggedIn) {
        String menuString = "";

        System.out.println("Please select one of the options: ");

        if (loggedIn) {
            menuString = "1. " + optionList.get(0) + "\n2. " + optionList.get(1) + "\n3. " + optionList.get(4) + "\n4. " + optionList.get(5);
        }
        else {
            menuString = "1. " + optionList.get(0) + "\n2. " + optionList.get(1) + "\n3. " + optionList.get(2) + "\n4. " + optionList.get(3) + "\n5. " + optionList.get(5);
        }

        System.out.println(menuString);
    }

}
