package com.cyy.cyyapibackend.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;


/**
 * 接口调用请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;


    /**
     * 用户的请求参数
     */
    private String userRequestParams;


}