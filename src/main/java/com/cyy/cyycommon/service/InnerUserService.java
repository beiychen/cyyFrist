package com.cyy.cyycommon.service;

import com.cyy.cyycommon.model.entity.User;


/**
 * 用户服务
 *
 */
public interface InnerUserService {

    /**
     * 数据库中查是否已分配给用户秘钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
