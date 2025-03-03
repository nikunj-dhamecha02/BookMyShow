import java.util.List;

public class PaymentProcessor {

  private static final double SERVICE_TAX = 0.14;
  private static final double SWACHH_CESS = 0.005;
  private static final double KRISHI_CESS = 0.005;

  public static double calculateTotalCost(List<Seat> bookedSeats) {
    double basePrice = 0;
    for (Seat seat : bookedSeats) {
      basePrice += seat.getSeatType().getPrice();
    }
    double serviceTax = basePrice * SERVICE_TAX;
    double swachhCess = basePrice * SWACHH_CESS;
    double krishiCess = basePrice * KRISHI_CESS;
    return basePrice + serviceTax + swachhCess + krishiCess;
  }
}
