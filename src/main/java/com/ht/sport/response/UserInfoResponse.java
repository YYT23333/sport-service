package com.ht.sport.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse extends Response {
    private List<UserNameAndAvatar> data;
    public UserInfoResponse(){
        this.code=200;
        this.msg="操作成功";
        this.data=new ArrayList<>();
    }
}
