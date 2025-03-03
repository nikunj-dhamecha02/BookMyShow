import java.util.List;

public class BookingService implements IBookingService{

  private final MovieTheater theater;

  public BookingService(MovieTheater theater) {
    this.theater = theater;
  }

  @Override
  public void bookShow(int showId, List<Seat> seats) {
    Auditorium auditorium = theater.getAuditorium(showId);
    if (auditorium != null) {
      Show show = auditorium.getShow();
      if (show.bookSeats(seats)) {
        System.out.println("Booking successful!");
      } else {
        System.out.println("Some seats are unavailable. Try again.");
      }
    } else {
      System.out.println("Invalid show ID.");
    }
  }
}
