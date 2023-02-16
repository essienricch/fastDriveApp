package africa.semicolon.project.uber_deluxe.data.repository;

import africa.semicolon.project.uber_deluxe.data.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository <Driver, Long> {
}
