package com.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
For detailed instructions, please refer to the README file.
It contains all the necessary guidelines and information for submitting and working with this project.
 */

public class Start {

  //you may remove the static keyword if required, and please DO NOT CREATE a new object for scanner class
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    List<Seat> seats1 = generateSeats(5, 8, 9);
    Auditorium auditorium1 = new Auditorium("Audi 1", seats1);
    Show show1 = new Show(1, auditorium1);

    List<Seat> seats2 = generateSeats(9, 6, 9);
    Auditorium auditorium2 = new Auditorium("Audi 2", seats2);
    Show show2 = new Show(2, auditorium2);

    List<Seat> seats3 = generateSeats(4, 8, 7);
    Auditorium auditorium3 = new Auditorium("Audi 3", seats3);
    Show show3 = new Show(3, auditorium3);

    MovieTheater theater = new MovieTheater(Arrays.asList(auditorium1, auditorium2, auditorium3));
    ShowService showService = new ShowService(Arrays.asList(show1, show2, show3));
    BookingService bookingService = new BookingService();
    while (true) {
      System.out.println("Enter show ID to book seats (or 0 to exit):");
      int showId = scanner.nextInt();
      if (showId == 0) {
        break;
      }
      Show show = showService.getShowById(showId);
      if (show != null) {
        Auditorium audi = show.getAuditorium();
        List<Seat> seats = audi.getAvailableSeats();
        System.out.println("Available Seats:");
        seats.forEach(x -> System.out.print(x.getSeatNumber()+ " "));
        System.out.println();
        System.out.println("Enter seat numbers (comma-separated):");
        scanner.nextLine();
        List<String> seatNumbers = Arrays.asList(scanner.nextLine().split(","));
        bookingService.bookShow(show, seatNumbers);
        System.out.println("Would you like to continue(Yes/No:");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("No")) {
          break;
        }
      }
    }
    BillingService.getInstance().getTotalSales();
  }

  public static List<Seat> generateSeats(int platSeats, int goldSeats, int silverSeats) {
    List<Seat> seats = new ArrayList<>();
    for (int i = 1; i <= platSeats; i++) {
      seats.add(new Seat("A" + i, SeatType.PLATINUM));
    }
    for (int i = 1; i <= goldSeats; i++) {
      seats.add(new Seat("B" + i, SeatType.GOLD));
    }
    for (int i = 1; i <= silverSeats; i++) {
      seats.add(new Seat("C" + i, SeatType.SILVER));
    }
    return seats;
  }
}
