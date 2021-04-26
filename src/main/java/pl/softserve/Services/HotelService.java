package pl.softserve.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.softserve.Models.Country;
import pl.softserve.Models.Hotel;
import pl.softserve.dao.HotelDAO;

import java.util.List;

@Service
public class HotelService {

    private final HotelDAO hotelDAO;

    public HotelService(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Transactional
    public List<Hotel> getAllHotels(){
        return hotelDAO.getAllHotels();
    }

    @Transactional
    public List<Country> getAllCountries(){
        return hotelDAO.getAllCountries();
    }

    @Transactional
    public List<Hotel> getHotelsByCountryId(int countryId){
        return hotelDAO.getHotelsByCountryId(countryId);
    }

    @Transactional
    public Hotel getHotel(int id){
        return hotelDAO.getHotel(id);
    }

    @Transactional
    public Hotel addHotel(Hotel hotel){
        return hotelDAO.addHotel(hotel);
    }

    @Transactional
    public void updateHotel(Hotel hotel){
        hotelDAO.updateHotel(hotel);
    }

    @Transactional
    public void deleteHotel(int id){
        hotelDAO.deleteHotel(id);
    }

}
