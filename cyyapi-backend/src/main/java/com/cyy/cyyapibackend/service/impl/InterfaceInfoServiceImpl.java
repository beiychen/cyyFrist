package com.cyy.cyyapibackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cyy.cyyapibackend.common.ErrorCode;
import com.cyy.cyyapibackend.exception.BusinessException;
import com.cyy.cyyapibackend.mapper.InterfaceInfoMapper;
import com.cyy.cyyapibackend.service.InterfaceInfoService;
import com.cyy.cyycommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author 陈
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-07-15 20:52:59
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        //校验
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        if (add) {
            if (StringUtils.isAnyBlank(name) ) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名字过长");
        }
    }

}




