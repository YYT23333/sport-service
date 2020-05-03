package com.ht.sport.feign;

import com.ht.sport.fallback.UserServiceFallback;
import com.ht.sport.response.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user-server",fallback = UserServiceFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "/user/getNameAndAvatar", method = RequestMethod.GET)
    UserInfoResponse getNameAndAvatar(@RequestParam("userid") List<Long> userid);

}
