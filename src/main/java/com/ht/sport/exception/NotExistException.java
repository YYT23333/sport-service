package com.ht.sport.exception;

import com.ht.sport.response.WrongResponse;

public class NotExistException extends Exception{
    private WrongResponse wrongResponse;
    public NotExistException(String type,Long id){
        super(type+id+",Not Exist!");
        wrongResponse=new WrongResponse(500,this.getMessage());
    }
}
