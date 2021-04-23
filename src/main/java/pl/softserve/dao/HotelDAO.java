package pl.softserve.dao;

import pl.softserve.Models.Hotel;

import java.util.List;

public interface HotelDAO {

    public void addHotel(Hotel h);
    public void updateHotel(Hotel h);
    public List<Hotel> listHotels();
    public Hotel getHotelById(int id);
    public Hotel getHotelByCountryId(int countryId);
    public void removeHotel(int id);


}
