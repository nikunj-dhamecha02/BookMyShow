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
        List<Seat> seats1 = generateSeats();
        Show show1 = new Show(1, "10:00 AM", seats1);
        Auditorium auditorium1 = new Auditorium("Audi 1", show1);

        List<Seat> seats2 = generateSeats();
        Show show2 = new Show(2, "1:00 PM", seats2);
        Auditorium auditorium2 = new Auditorium("Audi 2", show2);

        List<Seat> seats3 = generateSeats();
        Show show3 = new Show(2, "1:00 PM", seats3);
        Auditorium auditorium3 = new Auditorium("Audi 3", show3);

        MovieTheater theater = new MovieTheater(Arrays.asList(auditorium1, auditorium2, auditorium3));
        BookingService bookingService = new BookingService(theater);

        while (true) {
            System.out.println("Enter show ID to book seats (or 0 to exit):");
            int showId = scanner.nextInt();
            if (showId == 0) break;

            Auditorium auditorium = theater.getAuditorium(showId);
            if (auditorium == null) {
                System.out.println("Invalid show ID. Try again.");
                continue;
            }

            System.out.println("Available seats: " + auditorium.getShow().getAvailableSeats());

            System.out.println("Enter seat numbers (comma-separated):");
            scanner.nextLine();
            List<String> seatNumbers = Arrays.asList(scanner.nextLine().split(","));

            List<Seat> selectedSeats = new ArrayList<>();
            for (String seatNumber : seatNumbers) {
                for (Seat seat : auditorium.getShow().getAvailableSeats()) {
                    if (seat.getSeatNumber().equals(seatNumber)) {
                        selectedSeats.add(seat);
                    }
                }
            }
            bookingService.bookShow(showId, selectedSeats);
        }
        //your code from here......
    }

    public static List<Seat> generateSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 9; i++) seats.add(new Seat("A" + i, SeatType.PLATINUM));
        for (int i = 1; i <= 6; i++) seats.add(new Seat("B" + i, SeatType.GOLD));
        for (int i = 1; i <= 7; i++) seats.add(new Seat("C" + i, SeatType.SILVER));
        return seats;
    }
}
