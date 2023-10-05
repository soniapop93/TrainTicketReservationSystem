package Trains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Train {
    private long trainId;
    private String departureLocation;
    private String arrivalLocation;
    private int seatsAvailable;
    private int seatsTotal;

    public Train(long trainId, String departureLocation, String arrivalLocation, int seatsAvailable, int seatsTotal) {
        this.trainId = trainId;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.seatsAvailable = seatsAvailable;
        this.seatsTotal = seatsTotal;
    }
}
