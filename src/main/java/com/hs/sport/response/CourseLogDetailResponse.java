package com.hs.sport.response;

import com.hs.sport.entity.CourseLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseLogDetailResponse extends  Response{

    private CourseLogDetailItem item;

    public CourseLogDetailResponse(CourseLog courseLog){
        this.item=new CourseLogDetailItem(courseLog);
    }
}
