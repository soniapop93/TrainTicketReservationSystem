package Logic;

import Tickets.TicketLogic;
import Trains.TrainLogic;
import Users.AdminLogic;
import Users.User;
import Users.UserLogic;
import Utilities.InputFromUser;

import java.util.ArrayList;
import java.util.Arrays;

public class LogicTrainTicketReservationSystem {

    private final ArrayList<String> optionList = new ArrayList<String>(Arrays.asList(
            "See available train list",
            "Make a reservation",
            "Create new account",
            "Login in my account",
            "Logout",
            "Exit",
            "Add new train in database",
            "Show reserved tickets"));
    private boolean loggedIn = false;

    public void reservationSystem() {
        User authUser = null;
        InputFromUser inputFromUser = new InputFromUser();
        DatabaseLogic databaseLogic = new DatabaseLogic();
        UserLogic userLogic = new UserLogic(databaseLogic);
        TrainLogic trainLogic = new TrainLogic(databaseLogic);
        TicketLogic ticketLogic = new TicketLogic(databaseLogic);
        AdminLogic adminLogic = new AdminLogic(databaseLogic);
        boolean admin = false;

        String optionStrSelected = ">>> You have selected option: ";

        printWelcomeMessage();

        while (true) {
            if (authUser != null) {
                admin = authUser.isAdmin();
            }
            else {
                admin = false;
            }

            optionMenu(loggedIn, admin);
            System.out.print(">>> Add option number: ");
            String input = inputFromUser.getInputFromUser();
            System.out.println("-----------------------");

            if (loggedIn && admin == false) {
                switch (input) {
                    default:
                        System.out.println("Option not available");
                        break;

                    case "1": // See available train list
                        System.out.println(optionStrSelected + "1." + optionList.get(0) + "\n");

                        trainLogic.listTrains();

                        break;

                    case "2": // Make a reservation
                        System.out.println(optionStrSelected + "2." + optionList.get(1) + "\n");

                        if (authUser != null) {
                            ticketLogic.getReservationOptionsFromUser(authUser.getUserId());
                        }
                        break;

                    case "3": // Logout
                        System.out.println(optionStrSelected + "3." + optionList.get(4) + "\n");

                        loggedIn = false;
                        authUser = null;

                        System.out.println("Logged out");
                        break;
                    case "4": //Show reserved tickets
                        System.out.println(optionStrSelected + "4." + optionList.get(7) + "\n");

                        ticketLogic.getReservedTicketsForUser(authUser.getUserId());

                        break;

                    case "5": // Exit
                        System.out.println(optionStrSelected + "5." + optionList.get(5) + "\n");
                        return;
                }
            }
            else if (loggedIn == false && admin == false) {
                switch (input) {
                    default:
                        System.out.println(">> Option not available");
                        break;

                    case "1": // See available train list
                        System.out.println(optionStrSelected + "1." + optionList.get(0) + "\n");

                        trainLogic.listTrains();

                        break;

                    case "2": // Make a reservation
                        System.out.println(optionStrSelected + "2." + optionList.get(1) + "\n");

                        System.out.println(">> Please login or create new account before making any reservations");
                        System.out.println("----------------");
                        break;

                    case "3": // Create new account
                        System.out.println(optionStrSelected + "3." + optionList.get(2) + "\n");
                        userLogic.getNewUser(false);

                        break;

                    case "4": // Login in my account
                        System.out.println(optionStrSelected + "4." + optionList.get(3) + "\n");

                        loggedIn = userLogic.getCredentialsForLoginFromInput();

                        if (loggedIn) {
                            System.out.println(">> Logged in successfully");

                            authUser = userLogic.returnAuthUser();
                        }
                        else {
                            System.out.println(">> Try again. Username or password is incorrect...");
                        }
                        break;

                    case "5": // Exit
                        return;
                }
            }
            else if (admin) {
                switch (input) {
                    default:
                        System.out.println(">> Option not available");
                        break;

                    case "1": // See available train list
                        System.out.println(optionStrSelected + "1." + optionList.get(0) + "\n");

                        trainLogic.listTrains();

                        break;

                    case "2": // Add new train in database
                        System.out.println(optionStrSelected + "2. " + optionList.get(6) +"\n");
                        adminLogic.getInputFromAdminAddTrain();

                        break;

                    case "3": // Logout
                        System.out.println(optionStrSelected + "3." + optionList.get(4) + "\n");

                        loggedIn = false;
                        authUser = null;

                        System.out.println(">> Logged out");
                        break;

                    case "4": // Exit
                        System.out.println(optionStrSelected + "4." + optionList.get(5) + "\n");
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
    private void optionMenu(boolean loggedIn, boolean admin) {
        String menuString = "";

        System.out.println(">> Please select one of the options: ");

        if (loggedIn && admin == false) {
            menuString = "1. " + optionList.get(0) + "\n2. " + optionList.get(1) + "\n3. " + optionList.get(4) + "\n4. " + optionList.get(5);
        }
        else if (admin) {
            menuString = "1. " + optionList.get(0) + "\n2. " + optionList.get(6) + "\n3. " + optionList.get(4) + "\n4. " + optionList.get(5);
        }
        else {
            menuString = "1. " + optionList.get(0) + "\n2. " + optionList.get(1) + "\n3. " + optionList.get(2) + "\n4. " + optionList.get(3) + "\n5. " + optionList.get(5);
        }

        System.out.println(menuString);
        System.out.println("----------------------------------");
    }

}
