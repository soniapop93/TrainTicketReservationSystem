package Tickets;

import Users.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket
{
    private int ticketId;
    private String trainId;
    private String departureLocation;
    private String arrivalLocation;
    private int seatNumber;
    private double price;
    private LocalDateTime timeOfDeparture;
    private LocalDateTime estimatedTimeOfArrival;
    private boolean refundable;
    private LocalDateTime reservationTime;
    private User user;

    public Ticket(
            int ticketId,
            String trainId,
            String departureLocation,
            String arrivalLocation,
            int seatNumber,
            double price,
            LocalDateTime timeOfDeparture,
            LocalDateTime estimatedTimeOfArrival,
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
