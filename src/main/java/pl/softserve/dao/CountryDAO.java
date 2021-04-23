package pl.softserve.dao;

import pl.softserve.Models.Country;

import java.util.List;

public interface CountryDAO {

    public void addCountry(Country c);
    public void updateCountry(Country c);
    public List<Country> listCountries();
    public Country getCountryById(int id);
    public void removeCountry(int id);

}
