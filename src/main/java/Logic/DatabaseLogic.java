package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DatabaseLogic {
    private Connection connection;
    final String dbName = "train_ticket_reservation_database";
    final Map<String, String> tableNames = Map.ofEntries(Map.entry("users", "Users"), Map.entry("trains","Trains"), Map.entry("tickets", "Tickets"));

    public DatabaseLogic() {
        generateDB();
        createTableUsers();
        createTableTickets();
    }

    private void generateDB() {
        String fileName = dbName + ".db";
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

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(strSql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
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
    }
}
