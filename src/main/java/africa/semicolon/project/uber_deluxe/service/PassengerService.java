package africa.semicolon.project.uber_deluxe.service;

import africa.semicolon.project.uber_deluxe.data.dto.request.PassengerRegisterRequest;
import africa.semicolon.project.uber_deluxe.data.dto.response.PassengerRegisterResponse;
import africa.semicolon.project.uber_deluxe.data.dto.response.UpdatePassengerResponse;
import africa.semicolon.project.uber_deluxe.data.model.Passenger;
import com.github.fge.jsonpatch.JsonPatch;

public interface PassengerService {

    PassengerRegisterResponse register(PassengerRegisterRequest passengerRegisterRequest);

    Passenger getPassengerById(Long userId);
    UpdatePassengerResponse updatePassenger(Long passengerId, JsonPatch updatePayload);
}

