package Tickets;

import Users.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class Ticket
{
    private int ticketId;
    private int trainId;
    private String departureLocation;
    private String arrivalLocation;
    private int seatNumber;
    private double price;
    private LocalTime timeOfDeparture;
    private LocalTime estimatedTimeOfArrival;
    private boolean refundable;
    private LocalDateTime reservationTime;
    private User user;

    public Ticket(
            int ticketId,
            int trainId,
            String departureLocation,
            String arrivalLocation,
            int seatNumber,
            double price,
            LocalTime timeOfDeparture,
            LocalTime estimatedTimeOfArrival,
            boolean refundable,
            LocalDateTime reservationTime,
            User user) {
        this.ticketId = ticketId;
        this.trainId = trainId;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.seatNumber = seatNumber;
        this.price = price;
        this.timeOfDeparture = timeOfDeparture;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.reservationTime = reservationTime;
        this.refundable = refundable;
        this.user = user;
    }
}
