package com.cyy.cyyapibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyy.cyycommon.model.entity.InterfaceInfo;


/**
* @author 陈
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-07-15 20:52:59
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    //校验逻辑
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
