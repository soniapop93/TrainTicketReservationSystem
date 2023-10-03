package Tickets;

import java.time.LocalDateTime;

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
            boolean refundable)
    {
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

    public long getTicketId() { return ticketId; }
    public void setTicketId(long ticketId) { this.ticketId = ticketId; }

    public String getTrainId() {
        return trainId;
    }
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }
    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }
    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getTimeOfDeparture() {
        return timeOfDeparture;
    }
    public void setTimeOfDeparture(LocalDateTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public LocalDateTime getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }
    public void setEstimatedTimeOfArrival(LocalDateTime estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public boolean isRefundable() {
        return refundable;
    }
    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }
}
