package africa.semicolon.project.uber_deluxe.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneNumber;

    @OneToOne
    private Address address;

    private Gender gender;
    private String licenseId;
    private int age;

    @OneToOne
    private Referee referee;

    @OneToMany
    private Set <BankInformation> bankInformation;

    @OneToOne
    private AppUser userDetail;
}
