package pl.softserve.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal price; //added column
    private Date dateOfOrderPlaced;
    private Date checkIn;
    private Date checkOut;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDateOfOrderPlaced() {
        return dateOfOrderPlaced;
    }

    public void setDateOfOrderPlaced(Date dateOfOrderPlaced) {
        this.dateOfOrderPlaced = dateOfOrderPlaced;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
