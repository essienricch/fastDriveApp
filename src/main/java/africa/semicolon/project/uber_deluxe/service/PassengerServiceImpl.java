package africa.semicolon.project.uber_deluxe.service;

import africa.semicolon.project.uber_deluxe.data.dto.request.PassengerRegisterRequest;
import africa.semicolon.project.uber_deluxe.data.dto.response.PassengerRegisterResponse;
import africa.semicolon.project.uber_deluxe.data.dto.response.UpdatePassengerResponse;
import africa.semicolon.project.uber_deluxe.data.model.AppUser;
import africa.semicolon.project.uber_deluxe.data.model.Gender;
import africa.semicolon.project.uber_deluxe.data.model.Passenger;
import africa.semicolon.project.uber_deluxe.data.repository.PassengerRepository;
import africa.semicolon.project.uber_deluxe.mapper.FirstMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Slf4j
public class PassengerServiceImpl implements PassengerService{

    private final PassengerRepository passengerRepository;
    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    @Override
    public PassengerRegisterResponse register(PassengerRegisterRequest passengerRegisterRequest) {

        AppUser user = FirstMapper.map(passengerRegisterRequest);

        user.setCreatedAt(LocalDateTime.now());
        Passenger passenger = new Passenger();
        passenger.setUserDetail(user);
        passenger.setPhoneNumber("70504030");
        passenger.setGender(Gender.MALE);
        Passenger savedPassenger = passengerRepository.save(passenger);

        return getPassengerRegisterResponse(savedPassenger);
    }

    @Override
    public Passenger getPassengerById(Long userId) {
        return null;
    }

    @Override
    public UpdatePassengerResponse updatePassenger(Long passengerId, JsonPatch updatePayload) {
        Passenger foundPassenger =  getPassengerById(passengerId);
        Passenger updatedPassenger = null;
        JsonNode node = mapper.convertValue(foundPassenger, JsonNode.class);
        try{
            //apply patch
           JsonNode updateNode = updatePayload.apply(node);
           //node to Passenger Object
           log.info("updated node:: {}", updateNode);
           var res = JsonPatch.fromJson(updateNode);
           updatedPassenger = mapper.convertValue(res, Passenger.class);
        }catch(IOException | JsonPatchException e){
            log.error(e.getMessage());
        }
        return buildUpdatePassengerResponse(updatedPassenger);
    }

    private UpdatePassengerResponse buildUpdatePassengerResponse(Passenger updatedPassenger){
        return null;
    }

    private static PassengerRegisterResponse getPassengerRegisterResponse(Passenger savedPassenger) {
        PassengerRegisterResponse registerResponse = new PassengerRegisterResponse();
        registerResponse.setId(savedPassenger.getId());
        registerResponse.setCode(HttpStatus.CREATED.value());
        registerResponse.setSuccess(true);
        registerResponse.setMessage("Registration successful");
        return registerResponse;
    }
}
