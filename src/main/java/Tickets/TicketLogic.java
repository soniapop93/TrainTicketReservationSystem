package Tickets;

import Logic.DatabaseLogic;
import Trains.Train;
import Trains.TrainLogic;
import Users.User;
import Users.UserLogic;
import Utilities.InputFromUser;

import java.sql.*;
import java.time.LocalDateTime;

public class TicketLogic {
    private DatabaseLogic db;

    public TicketLogic(DatabaseLogic db) {
        this.db = db;
    }

    private Ticket makeReservation (int userId, int trainId) {
        TrainLogic trainLogic = new TrainLogic(db);
        UserLogic userLogic = new UserLogic(db);

        Train train = trainLogic.getTrain(trainId);
        User user = userLogic.returnUser(userId);


        if (train != null) {
            Ticket ticket = new Ticket(
                    -1,
                    train.getTrainId(),
                    train.getDepartureLocation(),
                    train.getArrivalLocation(),
                    train.getSeatsTotal() - train.getSeatsAvailable(), //todo: implement seats in db
                    train.getPrice(), //todo: implelemet price in train db
                    train.getTimeOfDeparture(), //todo: impplement timeofdeparture in train db
                    train.getEstimatedTimeOfArrival(), //todo: implement estimated time of arrival in train db
                    true,
                    LocalDateTime.now(),
                    user);

            return ticket;
        }

        return null;
    }

    public void getReservationOptionsFromUser(int userId) {
        InputFromUser inputFromUser = new InputFromUser();

        System.out.print("Please enter the train ID you want a ticket for: ");

        try {
            int trainId = Integer.parseInt(inputFromUser.getInputFromUser());

            if (trainId > 0) {

                Ticket ticket = makeReservation(userId, trainId);

                if (ticket != null) {
                    db.insertDataTickets(ticket);
                    System.out.println("Reservation ticket generated successfully");
                }
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
