import java.util.*;

class MovieTheater {
  private final List<Auditorium> auditoriums;

  public MovieTheater(List<Auditorium> auditoriums) {
    this.auditoriums = auditoriums;
  }

  public Auditorium getAuditorium(int showId) {
    for (Auditorium auditorium : auditoriums) {
      if (auditorium.getShow().getAvailableSeats() != null) {
        return auditorium;
      }
    }
    return null;
  }
}