package com.ht.sport.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class WrongResponse extends Response {
    public WrongResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
