package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.UserDTO;
import com.CookingMama.dev.domain.request.LoginRequest;
import com.CookingMama.dev.domain.request.SignupRequest;
import com.CookingMama.dev.domain.request.UserUpdateRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    Integer userSignup(SignupRequest request);
    UserDTO userLogin(LoginRequest request);
    UserDTO userInfo(Integer id);
    Integer updateUser(UserUpdateRequest request);
}
