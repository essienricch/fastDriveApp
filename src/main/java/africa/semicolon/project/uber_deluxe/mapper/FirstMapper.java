package africa.semicolon.project.uber_deluxe.mapper;

import africa.semicolon.project.uber_deluxe.data.dto.request.PassengerRegisterRequest;
import africa.semicolon.project.uber_deluxe.data.model.AppUser;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FirstMapper {

    public static AppUser map(PassengerRegisterRequest registerRequest){
        AppUser appUser = new AppUser();
        appUser.setName(registerRequest.getName());
        appUser.setEmail(registerRequest.getEmailAddress());
        appUser.setPassword(registerRequest.getPassword());
        return appUser;
    }
}
