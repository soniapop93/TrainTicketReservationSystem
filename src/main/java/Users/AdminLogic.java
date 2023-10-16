package Users;

import Logic.DatabaseLogic;

import java.io.File;

public class AdminLogic {

    private DatabaseLogic db;

    public AdminLogic(DatabaseLogic db) {this.db = db;}

    public void showAdminMeniu(UserLogic userLogic) {

        File file = new File ("./train_ticket_reservation_database.db");
        if (!file.exists()) {
            System.out.println("Hello admin user. Please add your credentials...");

            userLogic.getNewUser(true);

            System.out.println("Admin user registered successfully.");
        }
    }
}
