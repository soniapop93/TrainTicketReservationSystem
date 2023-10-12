package Tickets;

import Logic.DatabaseLogic;
import Trains.Train;
import Trains.TrainLogic;
import Users.UserLogic;

import java.sql.*;
import java.time.LocalDateTime;

public class TicketLogic {
    private DatabaseLogic db;

    public TicketLogic(DatabaseLogic db) {
        this.db = db;
    }

    public void makeReservation (int userId, int trainId) {
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
                    -1, //todo: implement seats in db
                    -1, //todo: implelemet price in train db
                    -1, //todo: impplement timeofdeparture in train db
                    -1, //todo: implement estimated time of arrival in train db
                    true,
                    LocalDateTime.now(),
                    );
        }
    }

}
