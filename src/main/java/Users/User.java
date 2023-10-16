package Users;

import Tickets.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class User
{
    private int userId;
    private boolean admin;
    private String userFirstName;
    private String userLastName;
    private String username;
    private String password;
    private String phoneNumber;
    private ArrayList<Ticket> tickets;
    public User(
            int userId,
            boolean admin,
            String userFirstName,
            String userLastName,
            String username,
            String password,
            String phoneNumber) {
        this.userId = userId;
        this.admin = admin;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}

