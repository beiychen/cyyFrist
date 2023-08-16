package com.cyy.cyyapibackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cyy.cyyapibackend.common.ErrorCode;
import com.cyy.cyyapibackend.exception.BusinessException;
import com.cyy.cyyapibackend.mapper.UserInterfaceInfoMapper;
import com.cyy.cyyapibackend.service.UserInterfaceInfoService;
import com.cyy.cyycommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
* @author 陈
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @createDate 2023-07-29 20:36:23
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        //校验
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //创建时，所有的参数必须非空
        if (add) {
            if(userInterfaceInfo.getInterfaceInfoId()<=0 || userInterfaceInfo.getUserId()<=0){
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或者用户不存在");
            }
        }

        if (userInterfaceInfo.getLeftNum() <0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 判断
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        //考虑并发

        //总调用次数加一，剩余次数减1
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




