package pl.softserve.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.softserve.Models.Country;
import pl.softserve.dao.CountryDAO;

import java.util.List;

@Service
public class CountryService {

    private final CountryDAO countryDAO;

    public CountryService(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Transactional
    public List<Country> getAllCountries(){
        return countryDAO.getAllCountries();
    }

    @Transactional
    public Country getCountry(int id){
        return countryDAO.getCountry(id);
    }

    @Transactional
    public void addCountry(Country country){
        countryDAO.addCountry(country);
    }

    @Transactional
    public void updateCountry(Country country){
        countryDAO.updateCountry(country);
    }

    @Transactional
    public void deleteCountry(int id){
        countryDAO.deleteCountry(id);
    }


}
