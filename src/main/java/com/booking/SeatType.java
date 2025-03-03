package com.booking;

enum SeatType {
  PLATINUM(320),
  GOLD(280),
  SILVER(240);

  private final int price;

  SeatType(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }
}
