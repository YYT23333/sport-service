package com.ht.sport.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CourseInfoResponse extends Response {
    private List<CourseNameAndAvatarItem> data;
    public CourseInfoResponse(){
        this.code=200;
        this.msg="操作成功";
        this.data=new ArrayList<>();
    }
}
