package entelect.training.incubator.spring.booking.bookingservice.model;

import lombok.Data;

@Data
public class BookingSearchRequest {
    private Integer id;

    private Integer customerId;

    private String referenceNumber;
    private SearchType searchType;
}
