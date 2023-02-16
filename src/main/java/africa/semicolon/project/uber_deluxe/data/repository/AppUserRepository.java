package africa.semicolon.project.uber_deluxe.data.repository;

import africa.semicolon.project.uber_deluxe.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository <AppUser, Long> {

}
