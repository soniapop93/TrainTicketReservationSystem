import Logic.LogicTrainTicketReservationSystem;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {
        // TrainTicketReservationSystem
        /*
        Requirements:
        [ ] - show trains available
		[ ] - user should select the train which he wants to make a reservation for
		[ ] - should select the number of seats (show also how many seats are available), the date for reservation and the location
        [ ] - user should login
        [ ] - if user doens't have an account, should create one
		[ ] - reserve seat and send confirmation of the reservation through mail
		[ ] - user can logout
         */

        LogicTrainTicketReservationSystem logic = new LogicTrainTicketReservationSystem();
        logic.reservationSystem();

    }
}