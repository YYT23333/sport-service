package com.ht.sport.fallback;

import com.ht.sport.feign.UserFeignClient;
import com.ht.sport.response.UserInfoResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class UserServiceFallback implements UserFeignClient {

    @Override
    public UserInfoResponse getNameAndAvatar(List<Long> userid) {
        return new UserInfoResponse();
    }
}
