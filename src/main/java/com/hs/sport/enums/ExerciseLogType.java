package com.hs.sport.enums;

public enum ExerciseLogType {
    RUNNING(1,"跑步"),
    SWIMMING(2,"游泳"),
    CYCLING(3,"骑行");
    private int index;
    private String name;
    private ExerciseLogType(int index,String name){
        this.index=index;
        this.name=name;
    }
}
