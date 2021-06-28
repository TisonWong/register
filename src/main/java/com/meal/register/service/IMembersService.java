package com.meal.register.service;

import com.meal.register.entity.Members;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
public interface IMembersService extends IService<Members> {

    boolean checkMemberPwd(Members members);

}
