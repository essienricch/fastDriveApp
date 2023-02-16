package africa.semicolon.project.uber_deluxe.data.repository;

import africa.semicolon.project.uber_deluxe.data.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository  extends JpaRepository <CreditCard, Long> {
}
