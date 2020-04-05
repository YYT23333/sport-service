package com.hs.sport.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class WrongResponse extends Response {
    public WrongResponse(String infoCode, String description) {
        this.code = infoCode;
        this.msg = description;
    }

}
