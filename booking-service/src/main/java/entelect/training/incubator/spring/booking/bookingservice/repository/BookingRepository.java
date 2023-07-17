package entelect.training.incubator.spring.booking.bookingservice.repository;


import entelect.training.incubator.spring.booking.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

    List<Booking> findByReferenceNumber(String referenceNumber);
    List<Booking>findByCustomerId(Integer customerId);
}
