package Users;

import Logic.DatabaseLogic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogic {
    private DatabaseLogic db;

    public UserLogic(DatabaseLogic db) {
        this.db = db;
    }

    public void addUser(User user) {
        db.insertDataUsers(user);
    }

    // Function that will get the user to be logged in, by username
    public boolean getUser(String username, String password){
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

                return checkIfPasswordIsCorrect(user, password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    private boolean checkIfPasswordIsCorrect(User user, String password) {
        return user.getPassword().equals(password);
    }
}
