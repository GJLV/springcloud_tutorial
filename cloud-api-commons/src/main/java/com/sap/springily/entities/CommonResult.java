package com.sap.springily.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    //如果data为空
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
