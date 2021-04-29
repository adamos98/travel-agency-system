package pl.softserve.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.softserve.Helpers.BookingParameters;
import pl.softserve.Models.Booking;
import pl.softserve.Models.Hotel;
import pl.softserve.Models.Room;
import pl.softserve.Models.User;
import pl.softserve.Services.BookingService;
import pl.softserve.Services.RoomService;
import pl.softserve.Services.UserService;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;
    private final RoomService roomService;

    public BookingController(BookingService bookingService, UserService userService, RoomService roomService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.roomService = roomService;
    }

    @RequestMapping(value = "/chooseBooking", method = RequestMethod.GET)
    public String chooseBooking(@ModelAttribute("bookingParameters") BookingParameters bookingParameters, Model model){
        List<Room> listOfAllRooms = roomService.getAllRooms();
        List<Hotel> listOfHotels = roomService.getAllHotels();
        model.addAttribute("booking", new Booking());
        model.addAttribute("room", new Room());
        model.addAttribute("listOfAllRooms", listOfAllRooms);
        model.addAttribute("listOfHotels", listOfHotels);
        return "chooseBooking";
    }

    @RequestMapping(value = "/makeBooking", method = RequestMethod.GET)
    public String bookingPage(@ModelAttribute("bookingParameters") BookingParameters bookingParameters,
                              @RequestParam String checkIn, @RequestParam String checkOut,
                              @RequestParam int hotelId, Model model, Principal principal){
        User user = userService.findByEmail(principal.getName());
        List<Room> listOfAllRooms = roomService.getAvailableRooms(checkOut,checkIn,hotelId);
        int idOfLoggedUser = user.getId();
        model.addAttribute("userId", idOfLoggedUser);
        model.addAttribute("booking", new Booking());
        model.addAttribute("listOfAllRooms", listOfAllRooms);
        return "makeBooking";
    }

    @RequestMapping(value = "/addBooking", method = RequestMethod.POST)
    public String addBooking(@RequestParam("roomId") int id,@ModelAttribute("bookingParameters") BookingParameters bookingParameters, Principal principal)
    {
        User user = userService.findByEmail(principal.getName());
        Booking booking = new Booking();
        booking.setUser(user);
        Room room = roomService.getRoom(id);
        booking.setRoom(room);
        String dateCheckIn = bookingParameters.getCheckIn();
        if(dateCheckIn.contains(","))
            dateCheckIn = dateCheckIn.substring(0,bookingParameters.getCheckIn().indexOf(","));
        String dateCheckOut = bookingParameters.getCheckOut();
        if(dateCheckOut.contains(","))
            dateCheckOut = dateCheckOut.substring(0,bookingParameters.getCheckOut().indexOf(","));
        booking.setCheckIn(LocalDate.parse(dateCheckIn));
        booking.setCheckOut(LocalDate.parse(dateCheckOut));
        booking.setPrice(BigDecimal.valueOf(2000));
        booking.setDateOfOrderPlaced(LocalDateTime.now());
        bookingService.addBooking(booking);
        return "menuView";
    }
}
