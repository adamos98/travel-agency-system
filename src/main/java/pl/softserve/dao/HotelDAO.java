package pl.softserve.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.softserve.Models.Booking;
import pl.softserve.Models.Country;
import pl.softserve.Models.Hotel;

import java.util.List;

@Repository
public class HotelDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public HotelDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Hotel> getAllHotels(){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Hotel>) session.createQuery("from Hotel ").list();
    }

    public List<Country> getAllCountries(){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Country>) session.createQuery("from Country ").list();
    }

    public List<Hotel> getHotelsByCountryId(int countryId){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Hotel>) session.createQuery(
                "from Hotel where country.id = '" + countryId + "'").list();
    }

    public Hotel getHotel(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Hotel.class, id);
    }

    public Hotel addHotel(Hotel hotel){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(hotel);
        return hotel;
    }

    public void updateHotel(Hotel hotel){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(hotel);
    }

    public void deleteHotel(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Hotel hotel = (Hotel) session.load(Hotel.class, id);
        if (null != hotel)
            session.delete(hotel);
    }
}
