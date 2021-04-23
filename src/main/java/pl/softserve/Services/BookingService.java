package pl.softserve.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.softserve.Models.Booking;
import pl.softserve.dao.BookingDAO;

import java.util.List;

@Service
public class BookingService {

    private final BookingDAO bookingDAO;


    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Transactional
    public List<Booking> getAllBookings(){
        return bookingDAO.getAllBookings();
    }

    @Transactional
    public Booking getBooking(int id){
        return bookingDAO.getBooking(id);
    }

    @Transactional
    public void addBooking(Booking booking){
        bookingDAO.addBooking(booking);
    }

    @Transactional
    public void updateBooking(Booking booking){
        bookingDAO.updateBooking(booking);
    }

    @Transactional
    public void deleteBooking(int id){
        bookingDAO.deleteBooking(id);
    }
}
