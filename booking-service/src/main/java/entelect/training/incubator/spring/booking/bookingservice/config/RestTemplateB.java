package entelect.training.incubator.spring.booking.bookingservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateB {


        public  static  final String FLIGHT_URL ="http://localhost:8202/flights/";
    public  static  final String CUSTOMER_URL ="http://localhost:8201/customers/";

}
