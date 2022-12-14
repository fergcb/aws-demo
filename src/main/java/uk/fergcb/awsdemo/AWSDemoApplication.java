package uk.fergcb.awsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AWSDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AWSDemoApplication.class, args);
    }

    @GetMapping
    public String sayHello() {
        return "Hola, Mundo!";
    }
}
