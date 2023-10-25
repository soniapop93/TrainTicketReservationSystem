package Users;

import Logic.DatabaseLogic;
import Utilities.InputFromUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogic {
    private DatabaseLogic db;
    private InputFromUser inputFromUser = new InputFromUser();

    private User userAuthenticated;

    public UserLogic(DatabaseLogic db) {
        this.db = db;
    }

    private void addUser(User user) {
        db.insertDataUsers(user);
        System.out.println("User registered");
    }

    private User getUser(String username, String password){
        ResultSet result = db.getUserByUsername(username);

        try {
            while (result.next()) {
                int userId = result.getInt("id");
                boolean admin = Boolean.parseBoolean(result.getString("admin"));
                String userFirstName = result.getString("firstName");
                String userLastName = result.getString("lastName");
                String email = result.getString("email");
                String userDB = result.getString("username");
                String passDB = result.getString("password");
                String phoneNumber = result.getString("phoneNumber");

                User user = new User(
                        userId,
                        admin,
                        userFirstName,
                        userLastName,
                        email,
                        userDB,
                        passDB,
                        phoneNumber);

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public User returnAuthUser(){
        return userAuthenticated;
    }

    public User returnUser(int userId) {
        ResultSet result = db.getUser(userId);

        try {
            while (result.next()) {
                boolean admin = result.getBoolean("admin");
                String userFirstName = result.getString("firstName");
                String userLastName = result.getString("lastName");
                String email = result.getString("email");
                String userDB = result.getString("username");
                String passDB = result.getString("password");
                String phoneNumber = result.getString("phoneNumber");

                User user = new User(
                        userId,
                        admin,
                        userFirstName,
                        userLastName,
                        email,
                        userDB,
                        passDB,
                        phoneNumber);

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public boolean getCredentialsForLoginFromInput() {
        System.out.print("Add username: ");
        String username = inputFromUser.getInputFromUser();


        System.out.print("Add password: ");
        String password = inputFromUser.getInputFromUser();

        if (username != null && password != null) {
            User user = getUser(username, password);

            if (user != null) {
                if (checkIfPasswordIsCorrect(user, password)) {
                    userAuthenticated = user;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void getNewUser(boolean admin) {
        System.out.print("Add First Name: ");
        String userFirstName = inputFromUser.getInputFromUser();

        System.out.print("Add Last Name: ");
        String userLastName = inputFromUser.getInputFromUser();

        System.out.print("Add email address: ");
        String email = inputFromUser.getInputFromUser();

        System.out.print("Add username: ");
        String username = inputFromUser.getInputFromUser();

        System.out.print("Add password: ");
        String password = inputFromUser.getInputFromUser();

        System.out.print("Add phoneNumber: ");
        String phoneNumber = inputFromUser.getInputFromUser();

        User user = new User(
                -1,
                admin,
                userFirstName,
                userLastName,
                email,
                username,
                password,
                phoneNumber);

        addUser(user);
    }

    private boolean checkIfPasswordIsCorrect(User user, String password) {
        return user.getPassword().equals(password);
    }
}
