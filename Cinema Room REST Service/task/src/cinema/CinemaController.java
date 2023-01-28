package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class CinemaController {
    Room room = new Room(9, 9);
    ArrayList<Purchase> soldTickets = new ArrayList<>();

    @GetMapping("/seats")
    public Room seats() {
        return room;
    }

    @PostMapping("/purchase")
    public Purchase purchase(@RequestBody Seat seat) {
        if (seat.getRow() < 1 || seat.getRow() > 9 || seat.getColumn() < 1 || seat.getColumn() > 9) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "The number of a row or a column is out of bounds!");
        }

        for (Seat s : room.getAvailable_seats()) {
            if (s.getRow() == seat.getRow() && s.getColumn() == seat.getColumn()) {
                room.getAvailable_seats().remove(s);
                UUID uuid = UUID.randomUUID();
                Purchase ticketSold = new Purchase(s, uuid.toString());
                soldTickets.add(ticketSold);
                return ticketSold;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "The ticket has been already purchased!");
    }

    @PostMapping("/return")
    public ReturnedSeat returnTicket(@RequestBody Token token) {

        for (Purchase purchase : soldTickets) {
            if (purchase.getToken().equals(token.getToken())) {
                ReturnedSeat returned = new ReturnedSeat();
                returned.setReturned_seat(purchase.getTicket());
                soldTickets.remove(purchase);
                room.addAvailable_seat(purchase.getTicket());
                return returned;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong token!");
    }

    @PostMapping("/stats")
    public Stats stats(@RequestBody Password password) {
        if (!password.getPassword().equals("super_secret")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The password is wrong!");
        } else {
            Stats stats = new Stats(room.getAvailable_seats().size(), soldTickets.size());
            soldTickets.forEach(ticket -> stats.setCurrent_income(ticket.getTicket().getPrice()));
            return stats;
        }
    }


}
