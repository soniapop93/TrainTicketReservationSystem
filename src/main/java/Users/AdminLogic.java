package Users;

import Logic.DatabaseLogic;
import Trains.TrainLogic;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLogic {

    private DatabaseLogic db;

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
        TrainLogic train = new TrainLogic(db);

        System.out.println("Add Departure Location:");
    }
}
