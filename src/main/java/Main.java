import Logic.DatabaseLogic;
import Logic.LogicTrainTicketReservationSystem;
import Trains.Train;
import Trains.TrainLogic;

public class Main
{
    public static void main(String[] args)
    {
        // TrainTicketReservationSystem
        /*
        Requirements:
        [X] - show trains available
		[X] - user should select the train which he wants to make a reservation for
		[ ] - should select the number of seats (show also how many seats are available), the date for reservation and the location
        [X] - user should log in
        [X] - if user doesn't have an account, should create one
		[ ] - reserve seat and send confirmation of the reservation through mail
		[X] - user can log out
		[ ] - when app is first time started, show menu to create an admin user
		[ ] - identify if the user is admin, and if yes show option to add trains in database
         */

        LogicTrainTicketReservationSystem logic = new LogicTrainTicketReservationSystem();
        logic.reservationSystem();

        //DatabaseLogic dbLogic = new DatabaseLogic();

        //TrainLogic trainLogic = new TrainLogic(dbLogic);

        //trainLogic.listTrains();

    }
}