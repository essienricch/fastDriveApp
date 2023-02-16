package africa.semicolon.project.uber_deluxe.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerRegisterRequest {
    @JsonProperty("email")
    private String emailAddress;
    private String name;
    @JsonProperty("password")
    private String password;
}
