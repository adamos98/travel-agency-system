package pl.softserve.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.softserve.Models.Hotel;
import pl.softserve.Models.Room;
import pl.softserve.Services.RoomService;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/getAllRooms", method = RequestMethod.GET)
    public String getAllRooms(Model model){
        List<Room> listOfRooms = roomService.getAllRooms();
        List<Hotel> listOfHotels = roomService.getAllHotels();
        model.addAttribute("room", new Room());
        model.addAttribute("listOfRooms", listOfRooms);
        model.addAttribute("listOfHotels", listOfHotels);
        return "roomManagement";
    }

    @RequestMapping(value = "/getRoom/{id}", method = RequestMethod.GET)
    public Room getRoomById(@PathVariable int id){
        return roomService.getRoom(id);
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("room") Room room){
        if(room.getId() == 0)
            roomService.addRoom(room);
        else
            roomService.updateRoom(room);
        return "redirect:/getAllRooms";
    }

    @RequestMapping(value = "/updateRoom/{id}", method = RequestMethod.GET)
    public String updateRoom(@PathVariable("id") int id, Model model){
        model.addAttribute("room", this.roomService.getRoom(id));
        model.addAttribute("listOfRooms", this.roomService.getAllRooms());
        model.addAttribute("listOfHotels", this.roomService.getAllHotels());
        return "roomManagement";
    }

    @RequestMapping(value = "/deleteRoom/{id}", method = RequestMethod.GET)
    public String deleteRoom(@PathVariable("id") int id){
        roomService.deleteRoom(id);
        return "redirect:/getAllRooms";
    }
}
