package entelect.training.incubator.spring.booking.bookingservice.controller;


import entelect.training.incubator.spring.booking.bookingservice.model.Booking;
import entelect.training.incubator.spring.booking.bookingservice.model.BookingSearchRequest;
import entelect.training.incubator.spring.booking.bookingservice.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings")
public class BookingsController {

    private final Logger LOGGER = LoggerFactory.getLogger(BookingsController.class);
    private final BookingService bookingService;
    public BookingsController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Integer id) {
        LOGGER.info("Processing booking search request for booking id={}", id);
            Booking booking = this.bookingService.getBookingById(id);
    System.out.println("BOOKING");
        if (booking != null) {
            LOGGER.trace("Found booking by customer id");
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }

        LOGGER.trace("booking not found");
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<?> makeBooking(@RequestBody Integer customerId , @RequestBody Integer flightId ) {
        LOGGER.info("Processing booking for {} on flight {}", customerId,flightId);
//
        Booking booking = bookingService.createBooking(customerId,flightId);
//
//        if (customer != null) {
//            return ResponseEntity.ok(customer);
//        }

        LOGGER.trace("Booking not found");
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/search")
    public ResponseEntity<?> searchBookings(@RequestBody BookingSearchRequest searchRequest) {
        LOGGER.info("Processing booking search request for request {}", searchRequest);
//
        List<Booking> booking = bookingService.searchBookings(searchRequest);


        if (booking != null && !booking.isEmpty()) {
            return ResponseEntity.ok(booking);
        }

        LOGGER.trace("Booking not found");
        return ResponseEntity.notFound().build();
    }
}
