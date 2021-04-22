package pl.softserve.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numberOfRoom;
    private boolean availability; // FIXME: 22-Apr-21 to think about this

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(String numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfRoom='" + numberOfRoom + '\'' +
                ", availability=" + availability +
                '}';
    }
}
