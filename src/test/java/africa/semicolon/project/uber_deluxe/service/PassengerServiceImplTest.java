package africa.semicolon.project.uber_deluxe.service;

import africa.semicolon.project.uber_deluxe.data.dto.request.PassengerRegisterRequest;
import africa.semicolon.project.uber_deluxe.data.dto.response.PassengerRegisterResponse;
import africa.semicolon.project.uber_deluxe.data.model.AppUser;
import africa.semicolon.project.uber_deluxe.data.model.Passenger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.ReplaceOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PassengerServiceImplTest {

    @Autowired
    private PassengerServiceImpl passengerService;
    private PassengerRegisterRequest registerRequest;

    @BeforeEach
    void setUp(){
      registerRequest = new PassengerRegisterRequest("justin29@gmail.com",
              "Justin Beiber","2023");
    }

    @Test
    void registerPassengerTest(){
//        PassengerRegisterRequest registerRequest = new PassengerRegisterRequest("justin29@gmail.com",
//                "Justin Beiber","2023");
        PassengerRegisterResponse registerResponse = passengerService.register(registerRequest);
        assertThat(registerResponse).isNotNull();
        assertThat(registerResponse.getCode()).isEqualTo(HttpStatus.CREATED.value());

    }

    @Test
    void getUserByIdTest(){
        var registerResponse = passengerService.register(registerRequest);
        Passenger foundPassenger = passengerService.getPassengerById(registerResponse.getId());
        assertThat(foundPassenger).isNotNull();
        AppUser userDetails = foundPassenger.getUserDetail();
        assertThat(userDetails.getName()).isEqualTo(foundPassenger.getUserDetail().getName());

    }

    @Test
    void updatePassengerTest() throws JsonPointerException {

        JsonPatch updatePayload =  new JsonPatch(List.of(new ReplaceOperation(new JsonPointer("/email"),
                new TextNode("fave@gmail.com"))));
        var registerResponse = passengerService.register(registerRequest);
        var updateResponse = passengerService.updatePassenger(registerResponse.getId(), updatePayload);


    }

}