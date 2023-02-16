package africa.semicolon.project.uber_deluxe.controller;

import africa.semicolon.project.uber_deluxe.data.dto.request.PassengerRegisterRequest;
import africa.semicolon.project.uber_deluxe.data.dto.response.PassengerRegisterResponse;
import africa.semicolon.project.uber_deluxe.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passenger")
@AllArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @PostMapping
    public ResponseEntity <?> registerPassenger(@RequestBody PassengerRegisterRequest passengerRegisterRequest){
        PassengerRegisterResponse passengerRegisterResponse = passengerService.register(passengerRegisterRequest);
        return ResponseEntity.status(passengerRegisterResponse.getCode()).body(passengerRegisterResponse);

    }


}
