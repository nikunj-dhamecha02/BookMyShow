import java.util.ArrayList;
import java.util.List;

public class Auditorium {

  private final String name;
  private final Show show;
  private List<Seat> seats;

  public Auditorium(String name, Show show) {
    this.name = name;
    this.seats = initializeSeats();
    this.show = show;
  }

  public Show getShow() { return show; }

  private List<Seat> initializeSeats() {
    List<Seat> seats = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      seats.add(new Seat("A" + i, SeatType.PLATINUM));
    }
    for (int i = 1; i <= 7; i++) {
      seats.add(new Seat("B" + i, SeatType.GOLD));
    }
    for (int i = 1; i <= 9; i++) {
      seats.add(new Seat("C" + i, SeatType.SILVER));
    }
    return seats;
  }


  public boolean isSeatAvailable(String seatNumber) {
    return seats.stream()
        .anyMatch(seat -> seat.getSeatNumber().equals(seatNumber) && seat.isAvailable());
  }

  public String getName() {
    return name;
  }

}
