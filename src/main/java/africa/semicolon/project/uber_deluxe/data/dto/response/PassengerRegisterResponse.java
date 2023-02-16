package africa.semicolon.project.uber_deluxe.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRegisterResponse {

    private Long id;
    private String message;
    private int code;
    private boolean isSuccess;
}
