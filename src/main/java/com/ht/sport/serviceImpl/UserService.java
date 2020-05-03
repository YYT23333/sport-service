package com.ht.sport.serviceImpl;

import com.ht.sport.response.UserInfoResponse;
import com.ht.sport.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserFeignClient userFeignClient;

    public UserInfoResponse getUserInfo(List<Long> userid) {
        return userFeignClient.getNameAndAvatar(userid);
    }

}
