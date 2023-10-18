package Trains;

import Logic.DatabaseLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
                double price = result.getDouble("price");
                double distance = result.getDouble("distance");
                LocalTime timeOfDeparture = LocalTime.parse(result.getString("timeOfDeparture"));
                LocalTime estimatedTimeOfArrival = LocalTime.parse(result.getString("estimatedTimeOfArrival"));


                Train train = new Train(
                        id,
                        departureLocation,
                        arrivalLocation,
                        seatsAvailable,
                        seatsTotal,
                        price,
                        distance,
                        timeOfDeparture,
                        estimatedTimeOfArrival);


                printResult(train);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrain(Train train) {
        db.insertDataTrains(train);
    }

    public Train getTrain(int trainId) {
        ResultSet trainResult = db.getTrainById(trainId);

        try {
            while(trainResult.next()) {
                int id = trainResult.getInt("id");
                String departureLocation = trainResult.getString("departureLocation");
                String arrivalLocation = trainResult.getString("arrivalLocation");
                int seatsAvailable = trainResult.getInt("seatsAvailable");
                int seatsTotal = trainResult.getInt("seatsTotal");
                double price = trainResult.getDouble("price");
                double distance = trainResult.getDouble("distance");
                LocalTime timeOfDeparture = LocalTime.parse(trainResult.getString("timeOfDeparture"));
                LocalTime estimatedTimeOfArrival = LocalTime.parse(trainResult.getString("estimatedTimeOfArrival"));


                Train train = new Train(
                        id,
                        departureLocation,
                        arrivalLocation,
                        seatsAvailable,
                        seatsTotal,
                        price,
                        distance,
                        timeOfDeparture,
                        estimatedTimeOfArrival);

                return train;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private void printResult(Train train) {

        String output = String.format("--> Train ID: %s | " +
                        "Departure Location: %s | " +
                        "Arrival Location: %s | " +
                        "Seats Available: %s | " +
                        "Total number of seats: %s | " +
                        "Price: %s € | " +
                        "Distance: %s KM | " +
                        "Time of Departure: %s | " +
                        "Estimated time of Arrival: %s",
                train.getTrainId(),
                train.getDepartureLocation(),
                train.getArrivalLocation(),
                train.getSeatsAvailable(),
                train.getSeatsTotal(),
                train.getPrice(),
                train.getDistance(),
                train.getTimeOfDeparture(),
                train.getEstimatedTimeOfArrival());

        System.out.println(output);
    }
}
