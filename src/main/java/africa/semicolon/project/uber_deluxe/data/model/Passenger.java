package africa.semicolon.project.uber_deluxe.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private AppUser userDetail;

}
