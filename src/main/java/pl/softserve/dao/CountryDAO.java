package pl.softserve.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.softserve.Models.Country;

import java.util.List;

@Repository
public class CountryDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAllCountries(){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Country>) session.createQuery("from Country ").list();
    }

    public Country getCountry(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Country.class, id);
    }

    public Country addCountry(Country country){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(country);
        return country;
    }

    public void updateCountry(Country country){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(country);
    }

    public void deleteCountry(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Country country = (Country) session.load(Country.class, id);
        if (null != country)
            session.delete(country);
    }


}
