package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.dto.UserDTO;
import com.CookingMama.dev.domain.request.LoginRequest;
import com.CookingMama.dev.domain.request.SignupRequest;
import com.CookingMama.dev.domain.request.UserUpdateRequest;
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
                    loginUser.getUserEmail(),
                    loginUser.getUserName(),
                    token
            );
        }
        return null;
    }
    public UserDTO userInfo(Integer id){
        UserDTO userInfo = userRepository.userInfo(id);
        if(userInfo != null){
            return userInfo;
        }
        return null;
    }

    public Integer userUpdate(UserUpdateRequest request){
        Integer updateSuccess = userRepository.updateUser(request);
        if(updateSuccess != null){
            return updateSuccess;
        }
        return null;
    }

}
