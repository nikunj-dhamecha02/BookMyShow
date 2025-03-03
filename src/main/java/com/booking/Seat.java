package com.booking;

public class Seat {

  private String seatNumber;
  private boolean isBooked;
  private SeatType type;

  public Seat(String seatNumber, SeatType type) {
    this.seatNumber = seatNumber;
    this.type = type;
    this.isBooked = false;
  }

  public boolean isAvailable() { return !isBooked; }
  public void book() { isBooked = true; }
  public String getSeatNumber() { return seatNumber; }
  public SeatType getSeatType() { return type; }



}
