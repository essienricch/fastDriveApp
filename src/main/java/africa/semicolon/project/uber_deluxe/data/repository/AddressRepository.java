package africa.semicolon.project.uber_deluxe.data.repository;

import africa.semicolon.project.uber_deluxe.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <Address, Long> {
}
