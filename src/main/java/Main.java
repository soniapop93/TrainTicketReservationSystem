import Logic.DatabaseLogic;
import Logic.LogicTrainTicketReservationSystem;
import Trains.Train;
import Trains.TrainLogic;
import Utilities.Mail;
import Utilities.SendMail;
import Utilities.WinCred;
import Utilities.WindowsCredentials;

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
		[ ] - reserve seat and send confirmation of the reservation through mail
		[X] - user can log out
		[X] - when app is first time started, show menu to create an admin user
		[X] - identify if the user is admin, and if yes show option to add trains in database
         */

        //LogicTrainTicketReservationSystem logic = new LogicTrainTicketReservationSystem();
        //logic.reservationSystem();

        //DatabaseLogic dbLogic = new DatabaseLogic();

        //TrainLogic trainLogic = new TrainLogic(dbLogic);

        //trainLogic.listTrains();

        WindowsCredentials winCredentials = new WindowsCredentials();

        WinCred.WinCredential credentialMail = winCredentials.getCredentials();


        SendMail sendmail = new SendMail(credentialMail);

        Mail mail = new Mail(
                "",
                "",
                "Testing",
                "This is a test");
        sendmail.send(mail);

    }
}