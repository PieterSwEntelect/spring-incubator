package entelect.training.incubator.spring.booking.bookingservice.service;


import entelect.training.incubator.spring.booking.bookingservice.model.*;
import entelect.training.incubator.spring.booking.bookingservice.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Supplier;

import static entelect.training.incubator.spring.booking.bookingservice.config.RestTemplateB.CUSTOMER_URL;
import static entelect.training.incubator.spring.booking.bookingservice.config.RestTemplateB.FLIGHT_URL;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;



    private final RestTemplate restTemplate;



    public BookingService(BookingRepository customerRepository, RestTemplateBuilder restTemplateBuilder) {
        this.bookingRepository = customerRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    public Booking createBooking(Integer cutsomerId, Integer flightID) {

        //Call Customer Service
       CustomerResponse customerResponse =  restTemplate.getForObject(CUSTOMER_URL+ cutsomerId,CustomerResponse.class);
        //Call Flight service
        FlightResponse flightResponse = restTemplate.getForObject(FLIGHT_URL+flightID,FlightResponse.class);
        //Store data if available or throw


        return null;
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> searchBookings(BookingSearchRequest searchRequest) {
        if (searchRequest.getSearchType() == SearchType.REFERENCE_NUMBER_SEARCH) {
            return bookingRepository.findByReferenceNumber(searchRequest.getReferenceNumber());
        } else {
            return bookingRepository.findByCustomerId(searchRequest.getCustomerId());
        }

    }
}
