package africa.semicolon.project.uber_deluxe.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Passenger passenger;
    private String cardNumber;
    private int cvv;
    private LocalDate expiryDate;
}
