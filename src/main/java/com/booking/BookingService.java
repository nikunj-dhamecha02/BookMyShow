package com.booking;

import java.util.List;

public class BookingService {

  public void bookShow(Show show, List<String> seats) {
    try {
      List<Seat> bookedSeats = show.getAuditorium().bookSeat(seats);
      BillingService billingService = BillingService.getInstance();
      double amount = billingService.calculateTotalCost(bookedSeats);
      System.out.println("Amount to be paid for confirming the booking: " + amount);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
