import Logic.LogicTrainTicketReservationSystem;

public class Main
{
    public static void main(String[] args)
    {
        // TrainTicketReservationSystem
        /*
        Requirements:
        [X] - show trains available
		[X] - user should select the train which he wants to make a reservation for
		[X] - should select the number of seats (show also how many seats are available), generate the date for reservation
        [X] - user should log in
        [X] - if user doesn't have an account, should create one
		[X] - reserve seat and send confirmation of the reservation through mail
		[X] - user can log out
		[X] - when app is first time started, show menu to create an admin user
		[X] - identify if the user is admin, and if yes show option to add trains in database
         */

        LogicTrainTicketReservationSystem logic = new LogicTrainTicketReservationSystem();
        logic.reservationSystem();
    }
}