package Users;

import Tickets.Ticket;

import java.util.ArrayList;

public class User
{
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String username;
    private String password;
    private String phoneNumber;
    private ArrayList<Ticket> tickets;

    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserFirstName()
    {
        return userFirstName;
    }
    public void setUserFirstName(String userFirstName)
    {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName()
    {
        return userLastName;
    }
    public void setUserLastName(String userLastName)
    {
        this.userLastName = userLastName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() {return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    

}

