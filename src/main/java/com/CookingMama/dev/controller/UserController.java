package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.request.LoginRequest;
import com.CookingMama.dev.domain.request.SignupRequest;
import com.CookingMama.dev.domain.response.UserResponse;
import com.CookingMama.dev.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public UserResponse userLogin(@RequestBody LoginRequest request){
        return userService.userLogin(request);
    }

    @PostMapping("/signup")
    public UserResponse userSignup(@RequestBody SignupRequest request){
        log.info(request.toString());
        return userService.userSignup(request);
    }
}
