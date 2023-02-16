package africa.semicolon.project.uber_deluxe.data.repository;

import africa.semicolon.project.uber_deluxe.data.model.BankInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInformationRepository extends JpaRepository <BankInformation, Long> {
}
