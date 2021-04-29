package pl.softserve.Helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BookingParameters {

    private BigDecimal price;
    private String dateOfOrderPlaced;
    private String checkIn;
    private String checkOut;
    private String hotelId;
    private String roomId;


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDateOfOrderPlaced() {
        return dateOfOrderPlaced;
    }

    public void setDateOfOrderPlaced(String dateOfOrderPlaced) {
        this.dateOfOrderPlaced = dateOfOrderPlaced;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }
}
