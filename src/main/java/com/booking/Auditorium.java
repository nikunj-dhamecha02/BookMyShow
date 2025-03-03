package com.booking;

import java.util.ArrayList;
import java.util.List;

public class Auditorium {

  private final String name;
  private final List<Seat> seats;

  public Auditorium(String name, List<Seat> seats1) {
    this.name = name;
    this.seats = seats1;
  }

  public String getName() {
    return name;
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

  public List<Seat> bookSeat(List<String> selectedSeats) throws Exception {
    List<Seat> markedSeats = selectedSeats.stream().map(seatId -> {
      return seats.stream().filter(x -> x.getSeatNumber().equals(seatId)).findFirst().orElse(null);
    }).toList();
    return bookSeats(markedSeats);
  }

  public List<Seat> bookSeats(List<Seat> selectedSeats) throws Exception {
    if (selectedSeats.stream().allMatch(Seat::isAvailable)) {
      selectedSeats.forEach(Seat::book);
      return selectedSeats;
    }
    throw new Exception("Can't book the already booked Seats");
  }
}



