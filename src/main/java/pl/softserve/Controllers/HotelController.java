package pl.softserve.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.softserve.Models.Country;
import pl.softserve.Models.Hotel;
import pl.softserve.Services.HotelService;

import java.util.List;

@Controller
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "/getAllHotels", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public String getHotels(Model model){
        List<Hotel> listOfHotels = hotelService.getAllHotels();
        List<Country> listOfCountries = hotelService.getAllCountries();
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("listOfHotels", listOfHotels);
        model.addAttribute("listOfCountries", listOfCountries);
        return "hotelManagement";
    }

    @RequestMapping(value = "/getAllHotelsByCountry", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public String getHotelsByCountry(Model model){
        List<Hotel> listOfHotels = hotelService.getAllHotels();
        List<Country> listOfCountries = hotelService.getAllCountries();
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("country", new Country());
        model.addAttribute("listOfHotels", listOfHotels);
        model.addAttribute("listOfCountries", listOfCountries);
        return "hotelsByCountry";
    }

    @RequestMapping(value = {"/getHotelsByCountryId/"}, method = RequestMethod.GET)
    public String getHotelsByCountryId(@RequestParam int id, Model model ){
        List<Hotel> listOfHotels = hotelService.getHotelsByCountryId(id);
        List<Country> listOfCountries = hotelService.getAllCountries();
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("country", new Country());
        model.addAttribute("listOfHotels", listOfHotels);
        model.addAttribute("listOfCountries", listOfCountries);
        return "hotelsByCountry";
    }

    @RequestMapping(value = "/getHotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Hotel getHotelById(@PathVariable int id){
        return hotelService.getHotel(id);
    }

    @RequestMapping(value = "/addHotel", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addHotel(@ModelAttribute("hotel") Hotel hotel){
        if(hotel.getId() == 0)
            hotelService.addHotel(hotel);
        else
            hotelService.updateHotel(hotel);

        return "redirect:/getAllHotels";
    }

    @RequestMapping(value = "/updateHotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateHotel(@PathVariable("id") int id, Model model){
        model.addAttribute("hotel", this.hotelService.getHotel(id));
        model.addAttribute("listOfHotels", this.hotelService.getAllHotels());
        model.addAttribute("listOfCountries",this.hotelService.getAllCountries());
        return "hotelManagement";
    }

    @RequestMapping(value = "/deleteHotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteHotel(@PathVariable("id") int id){
        hotelService.deleteHotel(id);
        return "redirect:/getAllHotels";
    }
}
