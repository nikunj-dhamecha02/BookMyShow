package com.booking;

import java.util.List;

public class BillingService {

  private static BillingService instance;
  private final double SERVICE_TAX = 0.14;
  private final double SWACHH_CESS = 0.005;
  private final double KRISHI_CESS = 0.005;
  private double TOTAL_REVENUE = 0.0;
  private double serviceTax = 0.0;
  private double swacchCess = 0.0;
  private double krishiCess = 0.0;

  public static BillingService getInstance() {
    if (instance == null) {
      instance = new BillingService();
    }
    return instance;
  }

  public double calculateTotalCost(List<Seat> bookedSeats) {
    double basePrice = 0;
    for (Seat seat : bookedSeats) {
      basePrice += seat.getSeatType().getPrice();
    }
    System.out.println("Subtotal: " + basePrice );
    double serviceTax = basePrice * SERVICE_TAX;
    System.out.println("Service Tax @14%: "+ serviceTax);
    this.serviceTax += serviceTax;
    double swachhCess = basePrice * SWACHH_CESS;
    System.out.println("Swachh Bharat Cess @0.5%: "+swachhCess);
    this.swacchCess += swachhCess;
    double krishiCess = basePrice * KRISHI_CESS;
    System.out.println("Krishi Kalyan Cess @0.5%: "+ krishiCess);
    this.krishiCess += krishiCess;
    TOTAL_REVENUE += basePrice + serviceTax + swachhCess + krishiCess;
    return basePrice + serviceTax + swachhCess + krishiCess;
  }

  public double getTotalRevenue(){
    return TOTAL_REVENUE;
  }

  public void getTotalSales(){
    System.out.println("Revenue : Rs. "+TOTAL_REVENUE);
    System.out.println("Service Tax: RS. "+serviceTax);
    System.out.println("Swachh Bharat Cess: RS. "+ swacchCess);
    System.out.println("Krishi Kalyan Cess: RS. "+ krishiCess);
  }
}
