package Trains;

import Logic.DatabaseLogic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainLogic {
    private DatabaseLogic db;

    public TrainLogic(DatabaseLogic db) {
        this.db = db;
    }
    public void listTrains() {
        ResultSet result = db.getAllTrains();


        try {
            while(result.next()) {
                int id = result.getInt("id");
                String departureLocation = result.getString("departureLocation");
                String arrivalLocation = result.getString("arrivalLocation");
                int seatsAvailable = result.getInt("seatsAvailable");
                int seatsTotal = result.getInt("seatsTotal");

                Train train = new Train(id, departureLocation, arrivalLocation, seatsAvailable, seatsTotal);

                printResult(train);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrain(Train train) {
        db.insertDataTrains(train);
    }

    private void printResult(Train train) {

        String output = String.format("Train ID: %s | Departure Location: %s | Arrival Location: %s | Seats Available: %s | Total Seats: %s",
                train.getTrainId(), train.getDepartureLocation(), train.getArrivalLocation(), train.getSeatsAvailable(), train.getSeatsTotal());

        System.out.println(output);
    }
}
