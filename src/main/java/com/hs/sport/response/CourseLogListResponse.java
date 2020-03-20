package com.hs.sport.response;

import com.hs.sport.entity.CourseLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CourseLogListResponse extends Response {
    private List<CourseLogItem> items;

    public CourseLogListResponse(List<CourseLog> logs) {
        this.items=new ArrayList<>();
        for (CourseLog log : logs) {
            items.add(new CourseLogItem(log));
        }
    }
}
