package com.CookingMama.dev.controller;

import com.CookingMama.dev.domain.dto.Hearts;
import com.CookingMama.dev.domain.dto.UserDTO;
import com.CookingMama.dev.domain.request.AddHeartsRequest;
import com.CookingMama.dev.domain.request.LoginRequest;
import com.CookingMama.dev.domain.request.SignupRequest;
import com.CookingMama.dev.domain.request.UserUpdateRequest;
import com.CookingMama.dev.domain.response.ItemListResponse;
import com.CookingMama.dev.domain.response.HeartsResponse;
import com.CookingMama.dev.domain.response.UserItemResponse;
import com.CookingMama.dev.domain.response.UserResponse;
import com.CookingMama.dev.security.SecurityService;
import com.CookingMama.dev.security.UserTokenInfo;
import com.CookingMama.dev.service.HeartsService;
import com.CookingMama.dev.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;
    private final SecurityService securityService;
    private final HeartsService heartsService;

    @GetMapping
    public List<ItemListResponse> getAllItem(){
        return userService.getAllItems();
    }
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

    @GetMapping("/hearts")
    public List<HeartsResponse> showHearts(){
        Integer userId = securityService.tokenToAdminDTO(securityService.getToken()).getId();
        return heartsService.showHearts(userId);
    }

    @PostMapping("/hearts")
    public Integer addHearts(@RequestBody AddHeartsRequest request){
        Integer userId = securityService.tokenToAdminDTO(securityService.getToken()).getId();
        request.setUserId(userId);
        log.info(request.toString());
        return heartsService.addHearts(request);
    }

    @GetMapping("/itemdetail/{itemId}")
    public UserItemResponse getOneItem(@PathVariable("itemId") Integer itemId){
        return userService.getOneItem(itemId);
    }
}
