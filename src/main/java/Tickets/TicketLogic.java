package Tickets;

import Logic.DatabaseLogic;
import Trains.Train;
import Trains.TrainLogic;
import Users.User;
import Users.UserLogic;

import java.sql.*;
import java.time.LocalDateTime;

public class TicketLogic {
    private DatabaseLogic db;

    public TicketLogic(DatabaseLogic db) {
        this.db = db;
    }

    public void makeReservation (int userId, int trainId, User user) {
        TrainLogic trainLogic = new TrainLogic(db);
        UserLogic userLogic = new UserLogic(db);

        Train train = trainLogic.getTrain(trainId);
        //todo: implement to get the User based on userid


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
        }
    }

}
