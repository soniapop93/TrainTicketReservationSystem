package Users;

import Logic.DatabaseLogic;
import Trains.Train;
import Trains.TrainLogic;
import Utilities.InputFromUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class AdminLogic {

    private DatabaseLogic db;
    private InputFromUser inputFromUser = new InputFromUser();

    public AdminLogic(DatabaseLogic db) {
        this.db = db;
        showAdminMeniu();
    }

    private void showAdminMeniu()
    {
        ResultSet adminResult = db.getAdmin();

        try {
            if (adminResult.next() == false) {
                System.out.println("Hello admin user. Please add your credentials...");

                UserLogic userLogic = new UserLogic(db);

                userLogic.getNewUser(true);

                System.out.println("Admin user registered successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getInputFromAdminAddTrain() {
        TrainLogic trainLogic = new TrainLogic(db);

        System.out.print("Add Departure Location: ");
        String departureLocation = inputFromUser.getInputFromUser();

        System.out.print("Add Arrival Location: ");
        String arrivalLocation = inputFromUser.getInputFromUser();

        System.out.print("Add Total Number of seats: ");
        int totalSeatsNumber = Integer.parseInt(inputFromUser.getInputFromUser());

        System.out.print("Add Distance: ");
        double distance = Double.parseDouble(inputFromUser.getInputFromUser());

        System.out.print("Add Time of Departure: ");
        LocalTime timeOfDeparture = LocalTime.parse(inputFromUser.getInputFromUser());

        System.out.print("Add Time of Arrival: ");
        LocalTime estimatedTimeOfArrival = LocalTime.parse(inputFromUser.getInputFromUser());

        int seatsAvailable = totalSeatsNumber;

        double price = 5 * distance;

        Train train = new Train(-1, departureLocation, arrivalLocation, seatsAvailable, totalSeatsNumber, price, distance, timeOfDeparture, estimatedTimeOfArrival);

        trainLogic.addTrain(train);
        System.out.println("Train successfully added in database");
    }
}
