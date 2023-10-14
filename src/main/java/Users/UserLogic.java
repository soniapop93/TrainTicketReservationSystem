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

    private void addUser(User user) {
        db.insertDataUsers(user);
        System.out.println("User registered");
    }

    // Function that will get the user to be logged in, by username
    private User getUser(String username, String password){
        ResultSet result = db.getUserByUsername(username);

        try {
            while (result.next()) {
                int userId = result.getInt("id");
                String userFirstName = result.getString("firstName");
                String userLastName = result.getString("lastName");
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

    public User returnUser(int userId) {
        ResultSet result = db.getUser(userId);

        try {
            while (result.next()) {
                String userFirstName = result.getString("firstName");
                String userLastName = result.getString("lastName");
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

    public void getNewUser() {
        System.out.print("Add First Name: ");
        String userFirstName = inputFromUser.getInputFromUser();

        System.out.print("Add Last Name: ");
        String userLastName = inputFromUser.getInputFromUser();

        System.out.print("Add username: ");
        String username = inputFromUser.getInputFromUser();

        System.out.print("Add password: ");
        String password = inputFromUser.getInputFromUser();

        System.out.print("Add phoneNumber: ");
        String phoneNumber = inputFromUser.getInputFromUser();

        User user = new User(-1, userFirstName, userLastName, username, password, phoneNumber);

        addUser(user);
    }

    private boolean checkIfPasswordIsCorrect(User user, String password) {
        return user.getPassword().equals(password);
    }
}
