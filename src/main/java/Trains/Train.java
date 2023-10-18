package Trains;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class Train {
    private int trainId;
    private String departureLocation;
    private String arrivalLocation;
    private int seatsAvailable;
    private int seatsTotal;
    private double price;
    private double distance;
    private LocalTime timeOfDeparture;
    private LocalTime estimatedTimeOfArrival;


    public Train(
            int trainId,
            String departureLocation,
            String arrivalLocation,
            int seatsAvailable,
            int seatsTotal,
            double price,
            double distance,
            LocalTime timeOfDeparture,
            LocalTime estimatedTimeOfArrival) {
        this.trainId = trainId;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.seatsAvailable = seatsAvailable;
        this.seatsTotal = seatsTotal;
        this.price = price;
        this.distance = distance;
        this.timeOfDeparture = timeOfDeparture;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }
}
