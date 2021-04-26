package pl.softserve.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.softserve.Models.Hotel;
import pl.softserve.Models.Room;

import java.util.List;

@Repository
public class RoomDAO {

    private final SessionFactory sessionFactory;

    public RoomDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Room> getAllRooms(){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Room>) session.createQuery("from Room ").list();
    }

    public List<Hotel> getAllHotels(){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Hotel>) session.createQuery("from Hotel ").list();
    }

    public Room getRoom(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Room.class,id);
    }

    public Room addRoom(Room room){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(room);
        return room;
    }

    public void updateRoom(Room room){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(room);
    }

    public void deleteCountry(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Room room = (Room) session.load(Room.class,id);
        if (null != room)
            session.delete(room);
    }
}
