package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseLogic {
    private Connection connection;
    final Map<String, String> dbNames = Map.ofEntries(Map.entry("users", "users"), Map.entry("trains","trains"), Map.entry("tickets", "tickets"));

    public DatabaseLogic() {
        generateDB();
    }

    private void generateDB() {
        String fileName = dbNames.get("users") + ".db";
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
            }
        }
    }
}
