package Logic;

import Tickets.Ticket;
import Trains.Train;
import Users.User;

import java.sql.*;
import java.time.LocalTime;
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

        try {
            connection = DriverManager.getConnection(strCon);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void createTableUsers() {
        String strSql = String.format("CREATE TABLE IF NOT EXISTS %s " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "admin BOOLEAN, " +
                "firstName TEXT, " +
                "lastName TEXT, " +
                "username TEXT, " +
                "password TEXT, " +
                "phoneNumber TEXT);", tableNames.get("users"));

        executeStatementUpdate(strSql);
    }

    private void createTableTickets() {
        String strSql = String.format("CREATE TABLE IF NOT EXISTS %s " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "trainID INTEGER, " +
                "departureLocation TEXT, " +
                "arrivalLocation TEXT, " +
                "seatNumber INTEGER, " +
                "price DOUBLE, " +
                "timeOfDeparture DATETIME, " +
                "estimatedTimeOfArrival DATETIME, " +
                "reservationTime DATETIME, " +
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
                "seatsTotal INTEGER, " +
                "price DOUBLE, " +
                "distance DOUBLE, " +
                "timeOfDeparture TEXT, " +
                "estimatedTimeOfArrival TEXT);", tableNames.get("trains"));
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

    public ResultSet getUser(int userId) {
        return getResultByColumnName(tableNames.get("users"), "id", Integer.toString(userId));
    }

    public ResultSet getAdmin() {
        return getResultByColumnName(tableNames.get("users"), "admin", Boolean.toString(true));
    }

    public ResultSet getUserByUsername(String username) {
        return getResultByColumnName(tableNames.get("users"), "username", username);
    }

    private ResultSet getTicketById(int ticketId) {
        return getResultByColumnName(tableNames.get("tickets"), "id", Integer.toString(ticketId));
    }

    private ResultSet getTicketsByUserId(int userId) {
        return getResultByColumnName(tableNames.get("tickets"), "id", Integer.toString(userId));
    }

    public ResultSet getTrainById(int trainId) {
        return getResultByColumnName(tableNames.get("trains"), "id", Integer.toString(trainId));
    }

    private ResultSet getResultByColumnName(String tableName, String columnName, String item) {
        String strSql = String.format("SELECT * FROM %s WHERE %s='%s'", tableName, columnName, item);
        ResultSet result = executeStatementQuery(strSql);

        return result;
    }

    private ResultSet getAll(String tableName) {
        String strSql = String.format("SELECT * FROM %s", tableName);
        ResultSet result = executeStatementQuery(strSql);

        return result;
    }

    public ResultSet getAllTrains() {
        return getAll(tableNames.get("trains"));
    }

    public void insertDataUsers(User user) {
        String strSql = String.format("INSERT INTO %s " +
                "(admin, firstName, lastName, username, password, phoneNumber) VALUES " +
                "('%s', '%s', '%s', '%s', '%s', '%s');", tableNames.get("users"),
                user.isAdmin(), user.getUserFirstName(), user.getUserLastName(), user.getUsername(), user.getPassword(), user.getPhoneNumber());

        executeStatementUpdate(strSql);
    }

    public void insertDataTickets(Ticket ticket) {
        String strSql = String.format("INSERT INTO %s " +
                "(trainID, departureLocation, arrivalLocation, seatNumber, price, timeOfDeparture, estimatedTimeOfArrival, refundable, reservationTime, userId) VALUES " +
                "('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", tableNames.get("tickets"),
                ticket.getTrainId(), ticket.getDepartureLocation(), ticket.getArrivalLocation(), ticket.getSeatNumber(), ticket.getPrice(), ticket.getTimeOfDeparture(), ticket.getEstimatedTimeOfArrival(), ticket.isRefundable(), ticket.getReservationTime(), ticket.getUser().getUserId());

        executeStatementUpdate(strSql);
    }

    public void insertDataTrains(Train train) {
        String strSql = String.format("INSERT INTO %s " +
                "(departureLocation, " +
                "arrivalLocation, " +
                "seatsAvailable, " +
                "seatsTotal, " +
                "price, " +
                "distance, " +
                "timeOfDeparture, " +
                "estimatedTimeOfArrival) VALUES " +
                "('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                tableNames.get("trains"),
                train.getDepartureLocation(),
                train.getArrivalLocation(),
                train.getSeatsAvailable(),
                train.getSeatsTotal(),
                train.getPrice(),
                train.getDistance(),
                train.getTimeOfDeparture().toString(),
                train.getEstimatedTimeOfArrival().toString());

        executeStatementUpdate(strSql);
    }

    public void updateSeatsNumberInTrains(int seatsNumber, int trainId) {
        String strSql = String.format("UPDATE %s SET %s=%s WHERE id=%s", tableNames.get("trains"), "seatsAvailable", seatsNumber, trainId);

        executeStatementUpdate(strSql);
    }
}
