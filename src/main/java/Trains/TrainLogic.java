package Trains;

import Logic.DatabaseLogic;

import java.sql.ResultSet;

public class TrainLogic {
    private DatabaseLogic db;

    public TrainLogic(DatabaseLogic db) {
        this.db = db;
    }
    public void listTrains() {
        ResultSet result = db.getAllTrains();

        //todo: implement to print it
    }
}
