package Logic;

import java.sql.*;
import java.util.Map;

public class DatabaseLogic {
    private Connection connection;
    final String dbName = "train_ticket_reservation_database";
    final Map<String, String> tableNames = Map.ofEntries(Map.entry("users", "Users"), Map.entry("trains","Trains"), Map.entry("tickets", "Tickets"));

    public DatabaseLogic() {
        generateDB();
        createTableUsers();
        createTableTickets();
        createTableTrains();
    }

    private void generateDB() {
        String fileName = dbName;
        createConnection(fileName);
    }

    private void createConnection(String fileName) {
        String strCon = String.format("jdbc:sqlite:%s.db", fileName);

        try
        {
            connection = DriverManager.getConnection(strCon);
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch(SQLException e)
            {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void createTableUsers()
    {
        String strSql = String.format("CREATE TABLE IF NOT EXISTS %s " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName TEXT, " +
                "lastNameText, " +
                "username TEXT, " +
                "password TEXT, " +
                "phoneNumber TEXT);", tableNames.get("users"));

        executeStatementUpdate(strSql);
    }

    private void createTableTickets() {
        String strSql = String.format("CREATE TABLE IF NOT EXISTS %s " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "trainID TEXT, " +
                "departureLocation TEXT, " +
                "arrivalLocation TEXT, " +
                "seatNumber INTEGER, " +
                "price DOUBLE, " +
                "timeOfDeparture DATETIME, " +
                "estimatedTimeOfArrival DATETIME, " +
                "refundable BOOLEAN, " +
                "userId INTEGER);", tableNames.get("tickets"));

        executeStatementUpdate(strSql);
    }

    private void createTableTrains() {
        String strSql = String.format("CREATE TABLE IF NOT EXISTS %s " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "departureLocation TEXT, " +
                "arrivalLocation TEXT, " +
                "seatsAvailable INTEGER, " +
                "seatsTotal INTEGER);", tableNames.get("trains"));
        executeStatementUpdate(strSql);
    }

    private void executeStatementUpdate(String strSql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(strSql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private ResultSet executeStatementQuery(String strSql) {
        ResultSet result = null;

        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(strSql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private ResultSet getUser(int userId) {

        String strSql = String.format("SELECT * FROM %s WHERE id=%s", tableNames.get("users"), userId);
        ResultSet result = executeStatementQuery(strSql);

        return result;
    }

}
