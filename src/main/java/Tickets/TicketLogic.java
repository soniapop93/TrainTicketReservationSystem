package Tickets;

import Logic.DatabaseLogic;
import Trains.Train;
import Trains.TrainLogic;
import Users.User;
import Users.UserLogic;
import Utilities.InputFromUser;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TicketLogic {
    private DatabaseLogic db;

    public TicketLogic(DatabaseLogic db) {
        this.db = db;
    }

    private Ticket makeReservation (int userId, int trainId, int seatsNumber) {
        TrainLogic trainLogic = new TrainLogic(db);
        UserLogic userLogic = new UserLogic(db);

        Train train = trainLogic.getTrain(trainId);
        User user = userLogic.returnUser(userId);

        int newAvailableSeatsInTrain = train.getSeatsAvailable() - seatsNumber;

        if (newAvailableSeatsInTrain < 0) {
            System.out.println(">> There are no more seats available in this train");
            return null;
        }

        db.updateSeatsNumberInTrains(newAvailableSeatsInTrain, train.getTrainId());

        if (train != null) {
            Ticket ticket = new Ticket(
                    -1,
                    train.getTrainId(),
                    train.getDepartureLocation(),
                    train.getArrivalLocation(),
                    seatsNumber,
                    train.getPrice(),
                    train.getTimeOfDeparture(),
                    train.getEstimatedTimeOfArrival(),
                    true,
                    LocalDateTime.now(),
                    user);

            // todo: implement to add in database the generated ticket

            return ticket;
        }

        return null;
    }

    public void getReservationOptionsFromUser(int userId) {
        InputFromUser inputFromUser = new InputFromUser();

        System.out.print("Please enter the train ID you want a ticket for: ");

        try {
            int trainId = Integer.parseInt(inputFromUser.getInputFromUser());


            System.out.print("Please enter the number of seats you want to reserve: ");
            int seatsNumber = Integer.parseInt(inputFromUser.getInputFromUser());

            if (trainId > 0 && seatsNumber > 0) {

                Ticket ticket = makeReservation(userId, trainId, seatsNumber);

                if (ticket != null) {
                    db.insertDataTickets(ticket);
                    System.out.println(">> Reservation ticket generated successfully");
                }
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void getReservedTicketsForUser(int userId) {
        ResultSet result = db.getTicketsByUserId(userId);

        try {
            while (result.next()) {
                int ticketId =  result.getInt("id");
                int trainId =  result.getInt("trainId");
                String departureLocation = result.getString("departureLocation");
                String arrivalLocation = result.getString("arrivalLocation");
                int seatNumber = result.getInt("seatNumber");
                double price = result.getDouble("price");
                LocalTime timeOfDeparture = LocalTime.parse(result.getString("timeOfDeparture"));
                LocalTime estimatedTimeOfArrival = LocalTime.parse(result.getString("estimatedTimeOfArrival"));
                boolean refundable = result.getBoolean("refundable");
                LocalTime reservationTime = LocalTime.parse(result.getString("reservationTime"));
                int userIdDB = result.getInt("userId");

                //todo: finish it
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
