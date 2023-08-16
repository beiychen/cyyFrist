package com.cyy.cyyapibackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 只含id，基本类型封装成对象
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}