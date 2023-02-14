package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.dto.UserDTO;
import com.CookingMama.dev.domain.request.LoginRequest;
import com.CookingMama.dev.domain.request.SignupRequest;
import com.CookingMama.dev.domain.response.UserResponse;
import com.CookingMama.dev.repository.UserRepository;
import com.CookingMama.dev.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SecurityService securityService;

    public UserResponse userSignup(SignupRequest request){
        Integer SignupRow = userRepository.userSignup(request);
        if(SignupRow!=null){
            LoginRequest loginRequest = new LoginRequest(request.getUserEmail(), request.getUserPw());
            return userLogin(loginRequest);
        }
        return null;
    }
    public UserResponse userLogin(LoginRequest request) {
        UserDTO loginUser = userRepository.userLogin(request);
        if (loginUser.getUserEmail() != null) {
            String token = securityService.createUserToken(loginUser);
            return new UserResponse(
                    loginUser.getId(),
                    loginUser.getUserName(),
                    loginUser.getUserPhoneNumber(),
                    loginUser.getUserBirth(),
                    loginUser.getUserAddress(),
                    loginUser.getUserAddressDetail(),
                    loginUser.getUserZipcode(),
                    token
            );
        }
        return null;
    }

}
