package pl.softserve.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.softserve.Models.Hotel;
import pl.softserve.Models.Room;
import pl.softserve.dao.RoomDAO;

import java.sql.Date;
import java.util.List;

@Service
public class RoomService {

    private final RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Transactional
    public List<Room> getAllRooms(){
        return roomDAO.getAllRooms();
    }

    @Transactional
    public List<Hotel> getAllHotels(){
        return roomDAO.getAllHotels();
    }

    @Transactional
    public List<Room> getAvailableRooms(String checkIn, String checkOut, int hotelId){
        return roomDAO.getAvailableRooms(checkIn,checkOut, hotelId);
    }

    @Transactional
    public Room getRoom(int id){
        return roomDAO.getRoom(id);
    }

    @Transactional
    public Room addRoom(Room room){
        return roomDAO.addRoom(room);
    }

    @Transactional
    public void updateRoom(Room room){
        roomDAO.updateRoom(room);
    }

    @Transactional
    public void deleteRoom(int id){
        roomDAO.deleteCountry(id);
    }
}
