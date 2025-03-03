import java.util.ArrayList;
import java.util.List;


class Show {

  private final int showId;
  private final String time;
  private final List<Seat> seats;

  public Show(int showId, String time, List<Seat> seats) {
    this.showId = showId;
    this.seats = seats;
    this.time = time;
  }

  public List<Seat> getAvailableSeats() {
    List<Seat> available = new ArrayList<>();
    for (Seat seat : seats) {
      if (seat.isAvailable()) {
        available.add(seat);
      }
    }
    return available;
  }

  public boolean bookSeats(List<Seat> selectedSeats) {
    if (selectedSeats.stream().allMatch(Seat::isAvailable)) {
      selectedSeats.forEach(Seat::book);
      return true;
    }
    return false;
  }
}
