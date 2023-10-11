package Users;

import Logic.DatabaseLogic;
import Utilities.InputFromUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogic {
    private DatabaseLogic db;
    InputFromUser inputFromUser = new InputFromUser();

    public UserLogic(DatabaseLogic db) {
        this.db = db;
    }

    public void addUser(User user) {
        db.insertDataUsers(user);
    }

    // Function that will get the user to be logged in, by username
    private User getUser(String username, String password){
        ResultSet result = db.getUserByUsername(username);

        try {
            while (result.next()) {
                int userId = result.getInt("id");
                String userFirstName = result.getString("userFirstName");
                String userLastName = result.getString("userLastName");
                String userDB = result.getString("username");
                String passDB = result.getString("password");
                String phoneNumber = result.getString("phoneNumber");

                User user = new User(userId, userFirstName, userLastName, userDB, passDB, phoneNumber);

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public boolean getCredentialsForLoginFromUser() {
        System.out.print("Add username: ");
        String username = inputFromUser.getInputFromUser();

        System.out.print("Add password: ");
        String password = inputFromUser.getInputFromUser();

        if (username != null && password != null) {
            User user = getUser(username, password);

            if (user != null) {
                return checkIfPasswordIsCorrect(user, password);
            }
        }
        return false;
    }

    private boolean checkIfPasswordIsCorrect(User user, String password) {
        return user.getPassword().equals(password);
    }
}
