package com.meal.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meal.register.entity.Members;
import com.meal.register.mapper.MembersMapper;
import com.meal.register.service.IMembersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Service
public class MembersServiceImpl extends ServiceImpl<MembersMapper, Members> implements IMembersService {

    @Override
    public boolean checkMemberPwd(Members members) {
        QueryWrapper<Members> queryWrapper = new QueryWrapper();
        if(null != members.getMemberEmail()){
            queryWrapper.eq("member_email",members.getMemberEmail());
        }else if(null != members.getMemberName()){
            queryWrapper.eq("member_name",members.getMemberName());
        }else if(null != members.getMemberPhone()){
            queryWrapper.eq("member_phone",members.getMemberPhone());
        }

        Members members1 = baseMapper.selectOne(queryWrapper);
        if(null == members1){
            return false;
        }else return members1.getMemberPwd().equals(members.getMemberPwd());

    }
}
