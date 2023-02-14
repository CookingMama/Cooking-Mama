package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.dto.UserDTO;
import com.CookingMama.dev.domain.request.LoginRequest;
import com.CookingMama.dev.domain.request.SignupRequest;
import com.CookingMama.dev.domain.request.UserUpdateRequest;
import com.CookingMama.dev.domain.response.UserResponse;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.security.UserTokenInfo;
import com.CookingMama.dev.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final SecurityService securityService;

    @PostMapping("/login")
    public UserResponse userLogin(@RequestBody LoginRequest request){
        return userService.userLogin(request);
    }

    @PostMapping("/signup")
    public UserResponse userSignup(@RequestBody SignupRequest request){
        return userService.userSignup(request);
    }

    @GetMapping("/my-page")
    public UserDTO userInfo(){
        String token = securityService.getToken();
        return userService.userInfo(securityService.tokenToDTO(token).getId());
    }
    @PutMapping("/my-page")
    public Integer updateUser(@RequestBody SignupRequest request){
        String token = securityService.getToken();
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest(securityService.tokenToDTO(token).getId(), request);
        return userService.userUpdate(userUpdateRequest);
    }
}
