package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.UserDTO;
import com.CookingMama.dev.domain.request.LoginRequest;
import com.CookingMama.dev.domain.request.SignupRequest;
import com.CookingMama.dev.domain.request.UserUpdateRequest;
import com.CookingMama.dev.domain.response.ItemListResponse;
import com.CookingMama.dev.domain.response.UserItemResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<ItemListResponse>  getAllItem();
    Integer userSignup(SignupRequest request);
    UserDTO userLogin(LoginRequest request);
    UserDTO userInfo(Integer id);
    Integer updateUser(UserUpdateRequest request);
    UserItemResponse getOneItem(Integer itemId);
}
