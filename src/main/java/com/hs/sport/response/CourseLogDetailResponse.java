package com.hs.sport.response;

import com.hs.sport.entity.CourseLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CourseLogDetailResponse extends  Response{
    @ApiModelProperty("返回数据")
    private CourseLogDetailItem data;

    public CourseLogDetailResponse(CourseLog courseLog){
        this.code = "200";
        this.msg = "操作成功！";
        this.data=new CourseLogDetailItem(courseLog);
    }
}
