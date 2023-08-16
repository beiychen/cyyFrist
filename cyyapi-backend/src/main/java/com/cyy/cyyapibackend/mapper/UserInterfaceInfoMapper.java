package com.cyy.cyyapibackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyy.cyycommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author 陈
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
* @createDate 2023-07-29 20:36:23
* @Entity generator.domain.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




