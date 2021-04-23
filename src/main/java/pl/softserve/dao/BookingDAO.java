package pl.softserve.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.softserve.Models.Booking;
import pl.softserve.Models.Country;

import java.util.List;

@Repository
public class BookingDAO {

    private final SessionFactory sessionFactory;

    public BookingDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Booking> getAllBookings(){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Booking>) session.createQuery("from Booking").list();
    }

    public Booking getBooking(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Booking.class,id);
    }

    public Booking addBooking(Booking booking){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(booking);
        return booking;
    }

    public void updateBooking(Booking booking){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(booking);
    }

    public void deleteBooking(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Booking booking = (Booking) session.load(Booking.class, id);
        if(null != booking)
            session.delete(booking);
    }

}
