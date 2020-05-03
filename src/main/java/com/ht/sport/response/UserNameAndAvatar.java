package com.ht.sport.response;

import lombok.Data;

@Data
public class UserNameAndAvatar {
    private String avatarUrl;
    private String name;
    private long userid;
}
