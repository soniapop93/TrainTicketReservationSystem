package Users;

import Logic.DatabaseLogic;
import Utilities.InputFromUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        boolean mailInPattern = false;
        String email = "";

        while (!mailInPattern) {
            System.out.print("Add email address: ");
            email = inputFromUser.getInputFromUser();

            mailInPattern = checkEmailPattern(email);
        }

        System.out.print("Add username: ");
        String username = inputFromUser.getInputFromUser();

        System.out.print("Add password: ");
        String password = inputFromUser.getInputFromUser();

        boolean phoneNumberInPattern = false;
        String phoneNumber = "";

        while (!phoneNumberInPattern) {
            System.out.print("Add phoneNumber: ");
            phoneNumber = inputFromUser.getInputFromUser();

            phoneNumberInPattern = checkPhoneNumberPattern(phoneNumber);
        }

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

    private boolean checkEmailPattern(String emailAddress) {
        if (!emailAddress.contains("@")) {
            return false;
        }

        String regexPattern = "^(.+)@(\\S+)$";
        return regexMatchFound(emailAddress ,regexPattern);
    }

    private boolean checkPhoneNumberPattern(String phoneNumber) {
        String regexPattern = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
        return regexMatchFound(phoneNumber ,regexPattern);
    }

    private boolean regexMatchFound (String input, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        if (matchFound) {
            return true;
        }
        return false;
    }
}
