package com.CookingMama.dev.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String userName;
    private String userPhoneNumber;
    private String userBirth;
    private String userAddress;
    private String userAddressDetail;
    private String userZipcode;
    private String token;
}
