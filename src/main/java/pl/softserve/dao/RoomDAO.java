package pl.softserve.dao;

import pl.softserve.Models.Room;

import java.util.List;

public interface RoomDAO {

public void addRoom(Room r);
public void updateRoom(Room r);
public List<Room> listRooms();
public Room getRoomById(int id);
public void removePerson(int id);

}
