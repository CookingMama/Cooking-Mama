package com.CookingMama.dev.security;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenInfo {
    private int id;
    private String userName;
    private String userPhoneNumber;
    private String userBirth;
    private String userAddress;
    private String userAddressDetail;
    private String userZipcode;

    public UserTokenInfo tokenToDTO(Claims claims) {
        Integer id = (Integer) claims.get("id");
        String name = (String) claims.get("userName");
        String phoneNumber = (String) claims.get("userPhoneNumber");
        String birth = (String) claims.get("userBirth");
        String address = (String) claims.get("userAddress");
        String addressDetail = (String) claims.get("userAddressDetail");
        String zipcode = (String) claims.get("userZipcode");

        return new UserTokenInfo(id, name, phoneNumber, birth, address, addressDetail, zipcode);
    }
}
