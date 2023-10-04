package Tickets;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket
{
    private long ticketId;
    private String trainId;
    private String departureLocation;
    private String arrivalLocation;
    private int seatNumber;
    private double price;
    private LocalDateTime timeOfDeparture;
    private LocalDateTime estimatedTimeOfArrival;
    private boolean refundable;

    public Ticket(
            long ticketId,
            String trainId,
            String departureLocation,
            String arrivalLocation,
            int seatNumber,
            double price,
            LocalDateTime timeOfDeparture,
            LocalDateTime estimatedTimeOfArrival,
            boolean refundable) {
        this.ticketId = ticketId;
        this.trainId = trainId;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.seatNumber = seatNumber;
        this.price = price;
        this.timeOfDeparture = timeOfDeparture;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.refundable = refundable;
    }
}
