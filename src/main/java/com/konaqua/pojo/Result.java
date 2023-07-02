package com.konaqua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

//统一响应对象
@Data
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;
}
