package com.hs.sport.response;

import com.hs.sport.entity.CourseLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
public class CourseLogListResponse extends Response {
    @ApiModelProperty("返回数据")
    private List<CourseLogItem> data;

    public CourseLogListResponse(List<CourseLog> logs) {
        this.data=new ArrayList<>();
        this.code = "200";
        this.msg = "操作成功！";
        for (CourseLog log : logs) {
            this.data.add(new CourseLogItem(log));
        }
    }
}
